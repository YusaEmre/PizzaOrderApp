package com.piyali.justeat.payload.request;

public class OrderEditRequest {
    private String orderId;
    private Double toppingPrice;

    public OrderEditRequest(String orderId, Double toppingPrice) {
        this.orderId = orderId;
        this.toppingPrice = toppingPrice;
    }

    public OrderEditRequest() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(Double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}
