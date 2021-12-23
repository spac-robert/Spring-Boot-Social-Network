package ro.robert.socialmediaspringboot.configuration;

import ro.robert.socialmediaspringboot.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.robert.socialmediaspringboot.repository.UserRepository;

import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User calu = new User("Calu", "Martin", "castorul_stirb", "nenea_martin@gmail.com");
            User daniel = new User("Ionut", "camatarul", "banigramada", "ionut@camataria.ro");
            User costel = new User("Costi", "Fortza", "fortza_modiala", "costi_fortza@manea.com");
            repository.saveAll(List.of(calu, daniel, costel));
        };
    }
}
