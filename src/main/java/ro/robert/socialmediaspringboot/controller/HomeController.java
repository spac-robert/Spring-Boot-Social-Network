package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.User;
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

    @RequestMapping(method = {RequestMethod.POST})
    public String searchBar(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.getAll());
        return "Home";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(Model model, @PathVariable String id) {
        User user = userService.findById(Long.parseLong(id));
        model.addAttribute("client", user);
        return "Home";
    }
}
