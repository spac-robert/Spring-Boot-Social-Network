package ro.robert.socialmediaspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.robert.socialmediaspringboot.entity.enumeration.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "to")
    private List<FriendRequest> friendRequests;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> friends;

    public User(String email, String firstName, String lastNName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastNName;
        this.password = password;
        this.role = UserRole.USER;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public void addFriend(User from) {
        this.friends.add(from);
        from.friends.add(this);
    }

    public void deleteFriend(User userById) {
        this.friends.remove(userById);
        userById.friends.remove(this);
    }
}

