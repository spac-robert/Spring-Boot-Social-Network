package ro.robert.socialmediaspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String lastNName;
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String email, String firstName, String lastNName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastNName = lastNName;
        this.password = password;
        this.role = UserRole.USER;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastNName='" + lastNName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
