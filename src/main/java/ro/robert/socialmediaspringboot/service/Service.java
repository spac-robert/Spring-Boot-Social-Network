package ro.robert.socialmediaspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.robert.socialmediaspringboot.domain.User;
import ro.robert.socialmediaspringboot.repository.UserRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final UserRepository repository;

    @Autowired
    public Service(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
