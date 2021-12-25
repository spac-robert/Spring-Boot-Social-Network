package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.encoder.Encrypt;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.UserService;


@org.springframework.stereotype.Controller
public class Controller {
    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("account", new User());
        return "Login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("account") User user, Model m) {
        String email = user.getEmail();
        String pass = Encrypt.encrypt(user.getPassword());
        System.out.println(email);
        User userFound = userService.findUserByEmail(email);
        if (userFound != null && userFound.getPassword().equals(pass)) {
            return "Home";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "Login";
    }

}

