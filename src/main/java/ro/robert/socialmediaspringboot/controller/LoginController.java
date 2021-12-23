package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.robert.socialmediaspringboot.domain.User;
import ro.robert.socialmediaspringboot.service.Service;

@Controller

public class LoginController {
    private final Service service;

    @Autowired
    public LoginController(Service service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "Login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        service.saveUser(user);
        model.addAttribute("user", user);
        return "redirect:/server-home-page";
    }
}
