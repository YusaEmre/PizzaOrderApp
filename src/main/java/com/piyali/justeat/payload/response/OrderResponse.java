package com.piyali.justeat.payload.response;

import com.piyali.justeat.model.Topping;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private String username;
    private String address;
    private List<Topping> toppingList;
}
