package ru.psy.kataHibernateMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.psy.kataHibernateMVC.models.User;
import ru.psy.kataHibernateMVC.services.UserService;

@Controller
@RequestMapping("/users/")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/index";
    }

    @GetMapping("/detail")
    public String show(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "/users/show";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        userService.update(user.getId(), user);
        redirectAttributes.addAttribute("id", user.getId());
        return "redirect:/users/";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/users/new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        userService.delete(id);
        return "redirect:/users/";
    }
}
