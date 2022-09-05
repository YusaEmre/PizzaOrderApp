package com.piyali.justeat.payload.response;

import com.piyali.justeat.model.Topping;


import java.util.List;


public class OrderResponse {

    private String username;
    private String address;
    private List<Topping> toppingList;


    public OrderResponse(String username, String address, List<Topping> toppingList) {
        this.username = username;
        this.address = address;
        this.toppingList = toppingList;
    }

    public OrderResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }
}
