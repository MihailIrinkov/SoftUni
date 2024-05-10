package com.likebookapp.controller;

import com.likebookapp.model.dto.post.PostHomeViewModel;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final UserService userService;
    private final PostService postService;

    public HomeController(LoggedUser loggedUser, UserService userService, PostService postService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/")
    private ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("/index");
    }


    @GetMapping("/home")
    private ModelAndView home() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        PostHomeViewModel postHomeViewModel = this.postService.getAll();

        return new ModelAndView("home", "allPosts", postHomeViewModel);
    }

    @GetMapping("/home/logout")
    public ModelAndView logout() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        userService.logout();
        return new ModelAndView("redirect:/");
    }

}
