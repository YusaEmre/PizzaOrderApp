package com.piyali.justeat.payload.request;

public class OrderEditRequest {
    private Long orderId;
    private Double toppingPrice;

    public OrderEditRequest(Long orderId, Double toppingPrice) {
        this.orderId = orderId;
        this.toppingPrice = toppingPrice;
    }

    public OrderEditRequest() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(Double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
}
