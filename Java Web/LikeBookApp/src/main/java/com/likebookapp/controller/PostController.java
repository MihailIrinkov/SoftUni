package com.likebookapp.controller;

import com.likebookapp.model.dto.post.PostBindingModel;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PostController {

    private final LoggedUser loggedUser;
    private final PostService postService;

    public PostController(LoggedUser loggedUser, PostService postService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
    }

    @GetMapping("/post-add")
    public ModelAndView add(
            @ModelAttribute("postBindingModel")
            PostBindingModel postBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("post-add");
    }

    @PostMapping("/post-add")
    public ModelAndView add(
            @ModelAttribute("postBindingModel")
            @Valid PostBindingModel postBindingModel,
            BindingResult bindingResult
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("post-add");
        }

        boolean successfulAddedPost = this.postService.addPost(postBindingModel);

        if (!successfulAddedPost) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("hasAddError", true);
            modelAndView.addObject("post-add");

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/post-like/{id}")
    public ModelAndView likePost(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        postService.like(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/post-remove/{id}")
    public ModelAndView removePost(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.postService.remove(id);
        return new ModelAndView("redirect:/home");
    }
}
