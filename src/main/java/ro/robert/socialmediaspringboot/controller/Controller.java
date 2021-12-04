package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.robert.socialmediaspringboot.service.Service;


@org.springframework.stereotype.Controller
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "Home";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "Users";
    }

}
