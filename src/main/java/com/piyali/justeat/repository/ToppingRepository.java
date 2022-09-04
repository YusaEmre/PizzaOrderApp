package com.piyali.justeat.repository;

import com.piyali.justeat.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepository extends JpaRepository<Topping,String> {
}
