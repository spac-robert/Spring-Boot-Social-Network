package ro.robert.socialmediaspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.RequestType;
import ro.robert.socialmediaspringboot.repository.FriendshipRepository;
import ro.robert.socialmediaspringboot.repository.UserRepository;

@Controller
@RequestMapping(value = "/request")
public class RequestController {
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    @Autowired
    public RequestController(UserRepository userRepository, FriendshipRepository friendshipRepository) {
        this.userRepository = userRepository;
        this.friendshipRepository = friendshipRepository;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public String sendFriendRequest(Model model, @PathVariable String id) {
        friendshipRepository.save(new FriendRequest(Client.getClient(), userRepository.getById(Long.valueOf(id)), RequestType.PENDING));
        return "redirect:/profile/" + id;
    }
}
