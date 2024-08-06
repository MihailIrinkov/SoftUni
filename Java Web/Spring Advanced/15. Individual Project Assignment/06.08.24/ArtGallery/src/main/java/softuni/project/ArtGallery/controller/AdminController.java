package softuni.project.ArtGallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.project.ArtGallery.model.dto.view.UserProfileViewModel;
import softuni.project.ArtGallery.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public ModelAndView adminPanel(){

        List<UserProfileViewModel> users = userService.getAll();

        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @PostMapping("/admin/{userId}")
    public ModelAndView delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);

        return new ModelAndView("redirect:/admin");
    }
}
