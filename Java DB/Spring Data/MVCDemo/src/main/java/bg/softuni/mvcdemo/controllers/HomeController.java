package bg.softuni.mvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home")
    public String home(
            @RequestParam(value = "show-ad", required = false)
            Integer adId) {
        System.out.println(adId);

        return "home";
    }
}
