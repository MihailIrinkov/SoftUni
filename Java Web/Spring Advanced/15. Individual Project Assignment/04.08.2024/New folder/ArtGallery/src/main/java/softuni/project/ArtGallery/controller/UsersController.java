package softuni.project.ArtGallery.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.project.ArtGallery.model.dto.binding.UserRegisterBindingModel;
import softuni.project.ArtGallery.model.dto.view.ChangeUsernameViewModel;
import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.service.AuthenticationService;
import softuni.project.ArtGallery.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult";
    public static final String DOT = ".";
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public UsersController(AuthenticationService authenticationService,
                           UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {

        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel",
                    new UserRegisterBindingModel());
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @Valid UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        final ModelAndView modelAndView = new ModelAndView();

        boolean hasSuccessfulRegister = this.authenticationService.register(userRegisterBindingModel);

        if (!hasSuccessfulRegister) {
            ModelAndView modelAndView1 = new ModelAndView("register");
            modelAndView1.addObject("hasRegisterError", true);

            return modelAndView1;
        }

        if (bindingResult.hasErrors()) {
            final String attributeName = "userRegisterBindingModel";
            redirectAttributes
                    .addFlashAttribute(attributeName, userRegisterBindingModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + DOT
                            + attributeName, bindingResult);
            modelAndView.setViewName("redirect:register");
        } else {
            this.authenticationService.register(userRegisterBindingModel);
            modelAndView.setViewName("redirect:login");
        }
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        UserProfileViewModel userProfileModel = userService.getUserProfile();

        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("userProfileModel", userProfileModel);

        return modelAndView;
    }

    @GetMapping("/change-username")
    public ModelAndView changeUsername(
            @ModelAttribute("changeUsernameViewModel")
            ChangeUsernameViewModel changeUsernameViewModel
    ) {

        return new ModelAndView("change-username");
    }


    @PostMapping("/change-username")
    public ModelAndView changeUsername(
            @ModelAttribute("changeUsernameViewModel") @Valid
            ChangeUsernameViewModel changeUsernameViewModel,
            BindingResult bindingResult
    ) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("change-username");

            return modelAndView;
        }

        boolean hasSuccessfulChange = this.userService.changeUsername(changeUsernameViewModel);

        if (!hasSuccessfulChange) {
            ModelAndView modelAndView = new ModelAndView("change-username");
            modelAndView.addObject("hasChangeError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }
}
