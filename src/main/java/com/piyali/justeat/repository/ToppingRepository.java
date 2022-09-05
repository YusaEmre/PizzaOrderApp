package com.piyali.justeat.repository;

import com.piyali.justeat.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToppingRepository extends JpaRepository<Topping,String> {

    Optional<Topping> findByToppingName(String toppingName);

    Optional<Topping> findByToppingPrice(Double toppingPrice);

}
