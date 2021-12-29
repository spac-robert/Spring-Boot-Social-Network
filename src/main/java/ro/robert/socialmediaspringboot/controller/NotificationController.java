package ro.robert.socialmediaspringboot.controller;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.ServiceController;

@Transactional
@Controller
@RequestMapping(value = "/notifications")
public class NotificationController {
    private final ServiceController serviceController;

    @Autowired
    public NotificationController(ServiceController serviceController) {
        this.serviceController = serviceController;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_notifications", serviceController.getAllRequests());
        return "Notification";
    }


    @RequestMapping(method = RequestMethod.POST, params = "profile")
    public String profile() {
        return "redirect:/profile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "accept")
    public String accept(@PathVariable String id) {
        FriendRequest friendRequest = serviceController.getFriendRequest(Long.parseLong(id));
        serviceController.deleteRequestByIdFrom(friendRequest.getFrom().getId());
        User loggedUser = serviceController.getUserById(Client.getClient().getId());
        loggedUser.addFriend(friendRequest.getFrom());
        serviceController.saveUser(loggedUser);
        return "redirect:/notifications";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "reject")
    public String reject(@PathVariable String id) {
        FriendRequest friendRequest = serviceController.getFriendRequest(Long.parseLong(id));
        serviceController.deleteRequestByIdFrom(friendRequest.getFrom().getId());
        return "redirect:/notifications";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String searchBar(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", serviceController.getAllUsers());
        return "Notification";
    }
}
