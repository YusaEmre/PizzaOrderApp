package com.piyali.justeat;

import com.piyali.justeat.model.User;
import com.piyali.justeat.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            repository.save(User.builder().userName("piyali")
                    .lastName("Bedagkar").name("piyali")
                        .address("India").isAdmin(true).phoneNumber("04502678992").password("Bedagkar12345").build());
                repository.save(User.builder().userName("Kote")
                    .lastName("Kote").name("laszlo")
                        .address("Turkey").isAdmin(false).phoneNumber("05321361234").password("KoteYusa12345").build());
        };
    }


}
