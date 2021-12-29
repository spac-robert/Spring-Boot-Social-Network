package ro.robert.socialmediaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.robert.socialmediaspringboot.entity.User;

@Repository
public interface UserFriendsRepository extends JpaRepository<User, Long> {
}