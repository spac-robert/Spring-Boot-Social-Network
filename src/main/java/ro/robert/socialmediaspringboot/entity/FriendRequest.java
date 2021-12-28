package ro.robert.socialmediaspringboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "friend_requests", schema = "public")
public class FriendRequest implements Serializable {
    @Id
    @Column(name = "rs_id")
    private long id;
    @JoinColumn(name = "rs_from", nullable = false, updatable = false, referencedColumnName = "id")
    @ManyToOne(optional = false, targetEntity = User.class)
    private User from;
    @JoinColumn(name = "rs_to", nullable = false, updatable = false, referencedColumnName = "id")
    @ManyToOne(optional = false, targetEntity = User.class)
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
}
