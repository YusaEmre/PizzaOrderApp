package com.piyali.justeat.repository;

import com.piyali.justeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUserNameAndPassword(String username, String password);
}
