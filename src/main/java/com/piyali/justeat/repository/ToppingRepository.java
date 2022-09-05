package com.piyali.justeat.repository;

import com.piyali.justeat.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToppingRepository extends JpaRepository<Topping,String> {

    Optional<Topping> findByToppingName(String toppingName);

    Optional<Topping> findByToppingPrice(Double toppingPrice);

}
