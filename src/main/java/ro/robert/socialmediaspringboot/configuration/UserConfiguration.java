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
            User calu = new User("calu", "XBelengherulx");
            User daniel = new User("daniel", "Xbelengherulx");
            User costel = new User("costel", "Xbelengherulx");
            repository.saveAll(List.of(calu, daniel, costel));
        };
    }
}
