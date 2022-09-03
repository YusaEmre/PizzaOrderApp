package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {


    @Id
    private Long orderId;

    private Double totalPrice;

    @ManyToMany
    private Set<Topping> topping;

    @ManyToOne
    private User userId;
}
