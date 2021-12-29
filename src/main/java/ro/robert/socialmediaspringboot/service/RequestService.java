package ro.robert.socialmediaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.robert.socialmediaspringboot.entity.Client;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.repository.RequestFriendshipRepository;

import java.util.List;

@Service
public class RequestService {
    private final RequestFriendshipRepository requestFriendshipRepository;

    @Autowired
    public RequestService(RequestFriendshipRepository friendshipRepository) {
        this.requestFriendshipRepository = friendshipRepository;
    }


    public List<FriendRequest> getAllRequests() {
        return requestFriendshipRepository.findFriendRequestByTo(Client.getClient());
    }

    public void save(FriendRequest friendRequest) {
        this.requestFriendshipRepository.save(friendRequest);
    }

    public void deleteRequestByIdFrom(long id) {
        requestFriendshipRepository.deleteByFromId(id);
    }

    public FriendRequest findById(long parseLong) {
        return requestFriendshipRepository.findById(parseLong).get();
    }
}
