package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String userName;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private Boolean isAdmin = false;

    @ManyToMany
    private Set<Topping> toppingList;
    @OneToMany
    private List<Order> orderList;
}
