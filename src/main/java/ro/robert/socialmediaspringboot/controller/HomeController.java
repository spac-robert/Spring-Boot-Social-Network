package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.robert.socialmediaspringboot.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        return "Home";
    }

    @RequestMapping(value = "", method = RequestMethod.POST, params = "profile")
    public String profile(){
        return "redirect:/profile";
    }
}
