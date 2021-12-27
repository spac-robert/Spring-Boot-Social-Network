package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
    private final UserService userService;

    @Autowired
    public SearchController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String search(@RequestParam(name = "search") String name, Model model) {
        List<User> users = userService.findByFirstName(name);
        model.addAttribute("users", users);
        return "Search";
    }

}
