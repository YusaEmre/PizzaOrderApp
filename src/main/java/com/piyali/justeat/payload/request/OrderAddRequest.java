package com.piyali.justeat.payload.request;





public class OrderAddRequest {
    private Long customerId;
    private String customerName;
    private String customerLastName;
    private String customerAddress;
    private String customerPhoneNumber;
    private Double toppingPrice;
    private Double totalPrice;
    private String deliveryDate;

    public OrderAddRequest(Long customerId, String customerName, String customerLastName, String customerAddress, String customerPhoneNumber, Double toppingPrice, Double totalPrice, String deliveryDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerAddress = customerAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        this.toppingPrice = toppingPrice;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderAddRequest() {
    }
}
