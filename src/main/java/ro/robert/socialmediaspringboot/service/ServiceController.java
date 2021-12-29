package ro.robert.socialmediaspringboot.service;

import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.entity.enumeration.RequestType;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceController {
    private final UserService userService;
    private final RequestService requestService;

    public ServiceController(UserService userService, RequestService requestService) {
        this.userService = userService;
        this.requestService = requestService;
    }

    public List<FriendRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    public List<User> getAllUsers() {
        return userService.getAll();
    }

    public void saveFriendship(long id) {
        FriendRequest friendRequest = new FriendRequest(Client.getClient(), userService.findById(id), RequestType.PENDING);
        requestService.save(friendRequest);
    }

    public void deleteRequestByIdFrom(long parseLong) {
        requestService.deleteRequestByIdFrom(parseLong);
    }

    public FriendRequest getFriendRequest(long parseLong) {
        return requestService.findById(parseLong);
    }


    public User saveUser(User loggedUser) {
        return userService.saveUser(loggedUser);
    }

    public User getUserById(Long id) {
        return userService.findById(id);
    }
}
