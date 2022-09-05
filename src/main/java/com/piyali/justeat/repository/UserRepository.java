package com.piyali.justeat.repository;

import com.piyali.justeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


    Optional<User> findByUserNameAndPassword(String username, String password);
    Optional<User> findByUserName(String username);
}
