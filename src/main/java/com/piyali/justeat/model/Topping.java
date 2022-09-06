package com.piyali.justeat.model;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.function.LongFunction;

@Entity
@Builder
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String toppingName;

    private Double toppingPrice;

    public Topping(Long id, String toppingName, Double toppingPrice) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


}