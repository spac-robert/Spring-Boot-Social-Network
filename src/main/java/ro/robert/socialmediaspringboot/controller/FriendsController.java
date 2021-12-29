package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.ServiceController;

@Controller
@RequestMapping("/friends")
public class FriendsController {
    private final ServiceController serviceController;

    @Autowired
    public FriendsController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @GetMapping
    public String index(Model model) {
        User user = serviceController.getUserById(Client.getClient().getId());
        model.addAttribute("friendsList", user.getFriends());
        return "Friends";
    }

    @RequestMapping(value = "", method = RequestMethod.POST, params = "profile")
    public String profile() {
        return "redirect:/profile";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String searchBar(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", serviceController.getAllUsers());
        return "Friends";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(Model model, @PathVariable String id) {
        User user = serviceController.getUserById(Long.parseLong(id));
        model.addAttribute("client", user);
        return "Friends";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "unfriend")
    public String deleteFriend(@PathVariable String id) {
        User user = serviceController.getUserById(Client.getClient().getId());
        User deleteUser = serviceController.getUserById(Long.parseLong(id));
        user.deleteFriend(deleteUser);
        serviceController.saveUser(user);
        return "redirect:/friends";
    }

}
