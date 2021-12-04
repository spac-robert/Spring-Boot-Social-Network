package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.robert.socialmediaspringboot.domain.User;
import ro.robert.socialmediaspringboot.service.Service;

import java.util.List;

@RestController
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String welcome() {
        return "Sugi pula";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }
}
