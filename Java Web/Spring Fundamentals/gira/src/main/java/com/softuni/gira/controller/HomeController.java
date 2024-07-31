package com.softuni.gira.controller;

import com.softuni.gira.model.dto.HomeViewDTO;
import com.softuni.gira.service.LoggedUser;
import com.softuni.gira.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final TaskService taskService;

    public HomeController(LoggedUser loggedUser,
                          TaskService taskService) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        HomeViewDTO tasks = this.taskService.getTasks();

        return new ModelAndView("home", "tasks", tasks);
    }

    @GetMapping("/manage-task/{name}")
    public ModelAndView manageTask(
            @PathVariable("name")
            String name
    ) {

        this.taskService.progressManager(name);

        return new ModelAndView("redirect:/home");
    }

}
