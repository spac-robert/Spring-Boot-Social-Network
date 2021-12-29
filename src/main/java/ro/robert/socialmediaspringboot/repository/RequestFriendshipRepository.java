package ro.robert.socialmediaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;

import java.util.List;

@Repository
public interface RequestFriendshipRepository extends JpaRepository<FriendRequest, Long> {
    List<FriendRequest> findFriendRequestByTo(User id);

    void deleteByFromId(long id);
}
