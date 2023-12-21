package bg.softuni.mvcdemo.controllers;

import bg.softuni.mvcdemo.dto.UserLoginDto;
import bg.softuni.mvcdemo.dto.UserRegisterDto;
import bg.softuni.mvcdemo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/users/login")
    public ModelAndView doLogin(@Valid UserLoginDto loginDto, BindingResult bindingResult) {

        if (loginDto.getUsername().equals("admin")
                && loginDto.getPassword().equals("secure")) {

            ModelAndView result = new ModelAndView();
            result.setViewName("redirect:/home");

            return result;
        }

        List<String> errors = bindingResult.getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .filter(e -> e != null)
                .toList();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        modelAndView.addObject("errors", errors);

        return modelAndView;
    }

    @GetMapping("/users/register")
    public String register() {
        return "user/register";
    }

    @PostMapping("/users/register")
    public String doRegister(@Valid UserRegisterDto userRegisterDto) {

        boolean success = userService.register(userRegisterDto);

        if (success) {
//            return "user/login";
            return "redirect:/users/login";
        }

        return "user/register";
    }

    @GetMapping("/users/info/{id}")
    public String getUserInfo(
            @PathVariable("id")
            long id) {
        System.out.println(id);

        return "home";
    }
}
