package ro.robert.socialmediaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.robert.socialmediaspringboot.entity.FriendRequest;

@Repository
public interface FriendshipRepository extends JpaRepository<FriendRequest, Long> {
}
