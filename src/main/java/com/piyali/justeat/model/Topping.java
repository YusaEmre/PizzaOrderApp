package com.piyali.justeat.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topping {

    @Id
    private Long id;

    private String toppingName;

    private Double toppingPrice;

}