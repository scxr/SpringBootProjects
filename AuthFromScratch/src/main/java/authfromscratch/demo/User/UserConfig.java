package authfromscratch.demo.User;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            UserMain charlie = new UserMain(
                    1L,
                    "Charlie",
                    "Charlie@gmail.com",
                    "Password"
            );

            UserMain nemo = new UserMain(
                    "Nemo",
                    "Nemo@gmail.com",
                    "Password"
            );

            repository.saveAll(List.of(charlie, nemo));
        };
    }
}
