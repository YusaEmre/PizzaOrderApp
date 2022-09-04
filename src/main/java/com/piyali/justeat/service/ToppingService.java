package com.piyali.justeat.service;

import com.piyali.justeat.model.Topping;
import com.piyali.justeat.repository.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToppingService {
    private final ToppingRepository toppingRepository;


    public List<Topping> getAllToppings(){
        return toppingRepository.findAll();
    }

}
