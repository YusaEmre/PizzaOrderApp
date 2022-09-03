package com.piyali.justeat.repository;

import com.piyali.justeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    boolean existsByUserNameAndPassword(String username,String password);
}
