package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = {RequestMethod.GET})
    public String getProfile(Model model) {
        model.addAttribute("client", Client.getClient());
        model.addAttribute("request",new FriendRequest());
        return "Profile";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String searchBar(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.getAll());
        return "Profile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(Model model, @PathVariable String id) {
        User user = userService.findById(Long.parseLong(id));
        model.addAttribute("client", user);
        return "Profile";
    }
}
