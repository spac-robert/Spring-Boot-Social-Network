package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.ServiceController;

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
        model.addAttribute("notifications", serviceController.getAllRequests());
        return "Notification";
    }


    @RequestMapping(value = "", method = RequestMethod.POST, params = "profile")
    public String profile() {
        return "redirect:/profile";
    }

    //TODO de implementat aceste 2
    @RequestMapping(value = "", method = RequestMethod.POST, params = "accept")
    public void accept() {
        System.out.println("ACCEPTED");
    }

    @RequestMapping(value = "", method = RequestMethod.POST, params = "reject")
    public void reject() {
        System.out.println("Rejected");
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String searchBar(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", serviceController.getAllUsers());
        return "Notification";
    }
}
