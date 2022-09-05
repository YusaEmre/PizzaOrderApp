package com.piyali.justeat;

import com.piyali.justeat.model.Topping;
import com.piyali.justeat.model.User;
import com.piyali.justeat.repository.ToppingRepository;
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
    /*
   @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
        repository.save(User.builder().userName("piyali")
                    .lastName("Bedagkar").name("piyali")
                        .address("India").isAdmin(true).phoneNumber("04502678992").password("1234").build());
                repository.save(User.builder().userName("kote")
                    .lastName("Kote").name("laszlo")
                        .address("Turkey").isAdmin(false).phoneNumber("05321361234").password("1234").build());

            repository.save(User.builder().userName("customer")
                    .lastName("customername").name("customerlastname")
                    .address("india").isAdmin(false).phoneNumber("05321361234").password("1234").build());
        };
    }
    */


  /*  @Bean
    public CommandLineRunner topping(ToppingRepository repository) {
        return (args) -> {
            repository.save(Topping.builder().toppingName("Mushroom")
                    .toppingPrice(50d)
                    .build());
            repository.save(Topping.builder().toppingName("No topping")
                    .toppingPrice(0d)
                    .build());
            repository.save(Topping.builder().toppingName("Capsicum")
                    .toppingPrice(30d)
                    .build());
            repository.save(Topping.builder().toppingName("Jalapeno")
                    .toppingPrice(70d)
                    .build());
            repository.save(Topping.builder().toppingName("Paneer")
                    .toppingPrice(85d)
                    .build());
        };
    }
*/

}
