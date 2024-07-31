package com.softuni.gira.controller;

import com.softuni.gira.model.dto.AddTaskBindingModel;
import com.softuni.gira.model.dto.TaskDTO;
import com.softuni.gira.service.LoggedUser;
import com.softuni.gira.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    private final LoggedUser loggedUser;
    private final TaskService taskService;

    public TaskController(LoggedUser loggedUser,
                          TaskService taskService) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
    }

    @GetMapping("/add-task")
    public ModelAndView addTask(
            @ModelAttribute("addTaskBindingModel")
            AddTaskBindingModel addTaskBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("add-task");
    }

    @PostMapping("/add-task")
    public ModelAndView addTask(
            @ModelAttribute("addTaskBindingModel") @Valid
            AddTaskBindingModel addTaskBindingModel,
            BindingResult bindingResult
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-task");
        }

        boolean hasSuccessfulAddedTask = this.taskService.addTask(addTaskBindingModel);

        if (!hasSuccessfulAddedTask) {
            ModelAndView modelAndView = new ModelAndView("add-task");
            modelAndView.addObject("hasAddError", true);
        }

        return new ModelAndView("redirect:/home");
    }


}
