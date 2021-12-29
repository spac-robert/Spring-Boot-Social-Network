package ro.robert.socialmediaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.robert.socialmediaspringboot.repository.UserFriendsRepository;

@Service
public class ServiceFriends {
    private UserFriendsRepository repository;

    @Autowired
    public ServiceFriends(UserFriendsRepository repository) {
        this.repository = repository;
    }

    public void saveFriendship(long id){
        //repository.sa
    }
}
