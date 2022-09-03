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
public class Order {


    @Id
    private Long orderId;

    private Double totalPrice;

    @ManyToMany
    private Set<Topping> topping;

    @ManyToOne
    private User userId;
}
