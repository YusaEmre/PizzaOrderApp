package com.piyali.justeat.repository;

import com.piyali.justeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Jpa repository contains a lot of ready to use functions, jpa creates  sql queries with hibernate
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUserNameAndPassword(String username, String password);
    Optional<User> findByUserName(String username);
}
