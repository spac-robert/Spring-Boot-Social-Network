package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.service.ServiceController;

@Controller
@RequestMapping(value = "/request")
public class RequestController {
    private final ServiceController service;

    @Autowired
    public RequestController(ServiceController service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET}, params = "send")
    public String sendFriendRequest(Model model, @PathVariable String id) {
        service.saveFriendship(Long.parseLong(id));
        return "redirect:/profile/" + id;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET}, params = "cancel")
    public String cancelFriendRequest(Model model, @PathVariable String id) {
        service.saveFriendship(Long.parseLong(id));
        return "redirect:/profile/" + id;
    }
}
