package com.piyali.justeat.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.piyali.justeat.model.Topping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderAddRequest {
    private String customerId;
    private String customerName;
    private String customerLastName;
    private String customerAddress;
    private String customerPhoneNumber;
    private Double toppingPrice;
    private Double totalPrice;
    private String deliveryDate;



}
