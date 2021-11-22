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

    @GetMapping(value = "/")
    public String allUsers(Model model) {
        List<User> userList = userServiceImpl.getAllUsers();
        model.addAttribute("AllUsers", userList);
        return "pages/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.show(id));
        return "pages/show";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/newUser";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceImpl.show(id));
        return "pages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userServiceImpl.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceImpl.removeUserById(id);
        return "redirect:/";
    }
}
