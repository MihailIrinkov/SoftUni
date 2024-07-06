package softuni.project.ArtGallery.controller;


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
import softuni.project.ArtGallery.model.dto.binding.AddArtistBindingModel;
import softuni.project.ArtGallery.model.dto.binding.UploadPictureArtistBindingModel;
import softuni.project.ArtGallery.model.dto.view.ArtistCategoryViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistDetailsViewModel;
import softuni.project.ArtGallery.model.dto.view.ArtistGetAllViewModel;
import softuni.project.ArtGallery.model.enums.CategoryNames;
import softuni.project.ArtGallery.service.ArtistService;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    @Value("${binding-result-package}")
    private String bindingResultPath;

    private static final String DOT = ".";
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {

        if (!model.containsAttribute("addArtistBindingModel")) {
            model.addAttribute("addArtistBindingModel", new AddArtistBindingModel());
        }

        return new ModelAndView("add-artist");
    }

    @PostMapping("/add")
    public ModelAndView add(
            @Valid AddArtistBindingModel addArtistBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            final String attributeName = "addArtistBindingModel";
            redirectAttributes
                    .addFlashAttribute(attributeName, addArtistBindingModel)
                    .addFlashAttribute(
                            bindingResultPath + DOT + attributeName,
                            bindingResult);
            modelAndView.setViewName("redirect:add");

        } else {
            artistService.add(addArtistBindingModel);
            modelAndView.setViewName("redirect:/");
        }
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAll() {
        List<ArtistGetAllViewModel> artists = artistService.getAll();

        ModelAndView modelAndView = new ModelAndView("artists");
        modelAndView.addObject("artists", artists);

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable("id") Long id) {
        ArtistDetailsViewModel artistDetailsViewModel = artistService.getDetails(id);

        ModelAndView modelAndView = new ModelAndView("artist-details");
        modelAndView.addObject("artists", artistDetailsViewModel);

        return modelAndView;
    }

    @PostMapping("/upload-picture")
    public ModelAndView uploadPicture(
            @Valid UploadPictureArtistBindingModel uploadPictureArtistBindingModel
    ) {
        artistService.uploadPicture(uploadPictureArtistBindingModel);

        return new ModelAndView("redirect:/artists");
    }

    @GetMapping("/{categoryName}")
    public ModelAndView getAllByCategory(
            @PathVariable("categoryName")
            CategoryNames categoryName) {
        List<ArtistCategoryViewModel> artists = artistService.getAllByCategory(categoryName);

        String view =
                switch (categoryName) {
                    case TEMPERA -> "tempera";
                    case WATERCOLOR -> "watercolor";
                    case OIL -> "oil";
                    case ACRYLIC -> "acrylic";
                };
        ModelAndView modelAndView = new ModelAndView(view);
        modelAndView.addObject("artists", artists);

        return modelAndView;
    }
}
