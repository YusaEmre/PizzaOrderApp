package com.piyali.justeat.service;

import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.Topping;
import com.piyali.justeat.repository.ToppingRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ToppingService {
    private final ToppingRepository toppingRepository;

    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }


    public Topping getToppingByPrice(Double price){
        return toppingRepository.findByToppingPrice(price).orElseThrow(()-> new NotFoundException("Topping not found"));
    }

    public Topping getToppingById(String id){
        return toppingRepository.findById(id).orElseThrow(()-> new NotFoundException("Topping not found"));
    }
    public List<Topping> getAllToppings(){
        return toppingRepository.findAll();
    }

}
