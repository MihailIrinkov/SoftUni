package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.service.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RestDemoController {

    private RestDemoService restDemoService;

    @Autowired
    public void setRestDemoController(RestDemoService userService) {
        this.restDemoService = userService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
//    @GetMapping("/users/all")
    public List<User> getAll() {
        return this.restDemoService.getAll();
    }

}
