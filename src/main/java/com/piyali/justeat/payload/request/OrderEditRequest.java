package com.piyali.justeat.payload.request;

public class OrderEditRequest {
    private Long orderId;
    private Double toppingPrice;

    private Double totalPrice;

    public OrderEditRequest(Long orderId, Double toppingPrice,Double totalPrice) {
        this.orderId = orderId;
        this.toppingPrice = toppingPrice;
        this.totalPrice= totalPrice;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
