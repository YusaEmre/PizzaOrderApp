package com.piyali.justeat.model;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@Entity
public class Topping {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;

    private String toppingName;

    private Double toppingPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public Double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(Double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public Topping(String id, String toppingName, Double toppingPrice) {
        this.id = id;
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }

    public Topping() {
    }

    public Topping(String toppingName, Double toppingPrice) {
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
    }
}