package ro.robert.socialmediaspringboot.configuration;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.robert.socialmediaspringboot.encoder.Encrypt;
import ro.robert.socialmediaspringboot.entity.FriendRequest;
import ro.robert.socialmediaspringboot.entity.User;
import ro.robert.socialmediaspringboot.repository.UserRepository;

import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User calu = new User("nenea_martin@gmail.com", "Calu", "Martin", Encrypt.encrypt("castorul_stirb"));
            User daniel = new User("ionut@camataria.ro", "Ionut", "camatarul", Encrypt.encrypt("banigramada"));
            User costel = new User("costi_fortza@manea.com", "Costi", "Fortza", Encrypt.encrypt("fortza_modiala"));
            User dan = new User("dan_barbasan@yahoo.com", "Dan", "Barbasan", Encrypt.encrypt("banigramada"));
            User castravete = new User("castrav@yahoo.com", "Ionut", "Castravete", Encrypt.encrypt("banigramada"));
            repository.saveAll(List.of(calu, daniel, costel, dan, castravete));
        };
    }
}