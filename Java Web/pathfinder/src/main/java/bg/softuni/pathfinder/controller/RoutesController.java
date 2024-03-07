package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.dto.binding.AddRouteBindingModel;
import bg.softuni.pathfinder.model.dto.view.RouteDetailsViewModel;
import bg.softuni.pathfinder.model.dto.view.RouteGetAllViewModel;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    @Value("${binding-result-package}")
    private String bindingResultPath;

    private static final String DOT = ".";
    private final RouteService routeService;

    public RoutesController(RouteService routeService) {
        this.routeService = routeService;
    }

//    @GetMapping("/add")
//    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel) {
//
//        ModelAndView modelAndView = new ModelAndView("add-route");
////        modelAndView.addObject("levels", Level.getEnumsAsList());
////        modelAndView.addObject("levels", Level.values());
////        modelAndView.addObject("categories", CategoryName.values());
//        modelAndView.addObject("addRouteBindingModel", addRouteBindingModel);
//
//        return modelAndView;
//    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {

        if (!model.containsAttribute("addRouteBindingModel")) {
            model.addAttribute("addRouteBindingModel", new AddRouteBindingModel());
        }

        return new ModelAndView("add-route");
    }

    @PostMapping("/add")
    public ModelAndView add(
            @Valid AddRouteBindingModel addRouteBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            final String attributeName = "addRouteBindingModel";
            redirectAttributes
                    .addFlashAttribute(attributeName, addRouteBindingModel)
                    .addFlashAttribute(
                            bindingResultPath + DOT + attributeName,
                            bindingResult);
            modelAndView.setViewName("redirect:add");

        } else {
            routeService.add(addRouteBindingModel);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAll() {
        List<RouteGetAllViewModel> routes = routeService.getAll();

        ModelAndView modelAndView = new ModelAndView("routes");
        modelAndView.addObject("routes", routes);

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable("id") Long id) {
        RouteDetailsViewModel routeDetailsViewModel = routeService.getDetails(id);

        ModelAndView modelAndView = new ModelAndView("route-details");
        modelAndView.addObject("route", routeDetailsViewModel);

        return modelAndView;
    }

}
