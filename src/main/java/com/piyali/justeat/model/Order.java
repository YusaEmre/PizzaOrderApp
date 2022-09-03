package com.piyali.justeat.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long orderId;

    private Double totalPrice;

    @ManyToMany
    private Set<Topping> topping;

    @ManyToOne
    private User user;
}
