package com.piyali.justeat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String orderId;

    private Double totalPrice;

    @ManyToOne
    private Topping topping;

    @ManyToOne
    private User user;

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate orderPlacedDate = LocalDate.now();

    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate deliveryDate;


}
