package ro.robert.socialmediaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.repository.FriendshipRepository;

import java.util.List;

@Service
public class RequestService {
    private final FriendshipRepository friendshipRepository;

    @Autowired
    public RequestService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }


    public List<FriendRequest> getAllRequests() {
        return friendshipRepository.findFriendRequestByTo(Client.getClient());
    }

    public void save(FriendRequest friendRequest) {
        this.friendshipRepository.save(friendRequest);
    }
}
