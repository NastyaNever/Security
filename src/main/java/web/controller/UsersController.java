package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserServiceImpl;

import java.util.List;


@Controller
public class UsersController {


    private final UserServiceImpl userServiceImpl;

    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "user/{id}")
    public String pageForUser(Model model, @PathVariable("id") long id,@ModelAttribute("user") User user) {
        model.addAttribute("user", userServiceImpl.show(id));
        return "pages/userPage" ;
    }
}