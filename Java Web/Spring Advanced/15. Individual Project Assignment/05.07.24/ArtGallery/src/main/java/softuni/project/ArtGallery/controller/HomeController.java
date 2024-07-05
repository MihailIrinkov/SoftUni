package softuni.project.ArtGallery.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.project.ArtGallery.model.dto.view.ArtistIndexViewModel;
import softuni.project.ArtGallery.service.ArtistService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArtistService artistService;

    @GetMapping("/")
    public String index(Model model) {
//        ArtistIndexViewModel artist = artistService.getMostCommentedArtist();

//        model.addAttribute("mostCommentedArtist", artist);

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }
}
