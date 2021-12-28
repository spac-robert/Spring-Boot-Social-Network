package ro.robert.socialmediaspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import ro.robert.socialmediaspringboot.entity.enumeration.RequestType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "friend_requests", schema = "public")
public class FriendRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rs_id")
    private long id;
    @JoinColumn(name = "rs_from", nullable = false, updatable = false, referencedColumnName = "id")
    @ManyToOne(optional = false, targetEntity = User.class, cascade = CascadeType.MERGE)
    private User from;
    @JoinColumn(name = "rs_to", nullable = false, updatable = false, referencedColumnName = "id")
    @ManyToOne(optional = false, targetEntity = User.class, cascade = CascadeType.MERGE)
    private User to;
    @Enumerated(EnumType.STRING)
    private RequestType type;

    public FriendRequest(User from, User to, RequestType type) {
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public FriendRequest() {

    }

    public FriendRequest(User from, User to) {
        this.from = from;
        this.to = to;
        this.type = RequestType.PENDING;
    }

    public String getFriendRequest() {
        return "Friend request: " + from.getFullName() + " " + type;
    }

}
