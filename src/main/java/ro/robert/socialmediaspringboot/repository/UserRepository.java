package ro.robert.socialmediaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.robert.socialmediaspringboot.entity.RequestType;
import ro.robert.socialmediaspringboot.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByFirstName(String firstName);
}
