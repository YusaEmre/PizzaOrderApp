package com.piyali.justeat.repository;

import com.piyali.justeat.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Jpa repository contains a lot of ready to use functions, jpa creates  sql queries with hibernate
@Repository
public interface ToppingRepository extends JpaRepository<Topping,Long> {

    Optional<Topping> findByToppingName(String toppingName);

    Optional<Topping> findByToppingPrice(Double toppingPrice);

}
