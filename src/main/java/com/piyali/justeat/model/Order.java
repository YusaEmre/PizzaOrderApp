package com.piyali.justeat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

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

    public Order(String orderId, Double totalPrice, Topping topping, User user, LocalDate orderPlacedDate, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.topping = topping;
        this.user = user;
        this.orderPlacedDate = orderPlacedDate;
        this.deliveryDate = deliveryDate;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getOrderPlacedDate() {
        return orderPlacedDate;
    }

    public void setOrderPlacedDate(LocalDate orderPlacedDate) {
        this.orderPlacedDate = orderPlacedDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Order(Double totalPrice, Topping topping, User user, LocalDate deliveryDate) {
        this.totalPrice = totalPrice;
        this.topping = topping;
        this.user = user;
        this.deliveryDate = deliveryDate;
    }
}
