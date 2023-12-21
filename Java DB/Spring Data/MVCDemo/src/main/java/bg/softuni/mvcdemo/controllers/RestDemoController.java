package bg.softuni.mvcdemo.controllers;

import bg.softuni.mvcdemo.dto.UserShortInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestDemoController {

    @GetMapping("")
    public String index() {
        return "user/login";
    }

    @GetMapping("/dto")
    public UserShortInfoDto getDto () {
        return new UserShortInfoDto("demo-user");
    }

    @PostMapping("/create")
    public void create(UserShortInfoDto userShortInfoDto) {
        System.out.println(userShortInfoDto.getUsername());
    }
}
