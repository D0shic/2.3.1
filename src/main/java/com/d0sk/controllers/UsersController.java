package com.d0sk.controllers;

import com.d0sk.models.User;
import com.d0sk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/user-form")
    public String showForm(@RequestParam(value = "userId", required = false) Long id, Model model) {
        User user = id != null ? userService.findById(id) : new User();
        model.addAttribute("user", user);
        return "users/userForm";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
