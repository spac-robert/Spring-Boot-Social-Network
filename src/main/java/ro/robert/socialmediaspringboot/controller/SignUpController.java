package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.repository.UserRepository;

@Controller
public class SignUpController {
    private UserRepository userRepository;

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String index(Model model) {
        model.addAttribute("account", new User());
        return "SignUp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "signup")
    public String signUp(@ModelAttribute("account") User user, Model m) {
        System.out.println(user);
        //
        m.addAttribute("errorMessage", "Last name can't be blank");
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, params = "login")
    public String back(@ModelAttribute("account") User user, Model model) {
        return "redirect:/login";
    }
}
