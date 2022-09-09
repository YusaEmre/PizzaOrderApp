package com.piyali.justeat;

import com.piyali.justeat.model.Topping;
import com.piyali.justeat.model.User;
import com.piyali.justeat.repository.ToppingRepository;
import com.piyali.justeat.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


//
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }


}
