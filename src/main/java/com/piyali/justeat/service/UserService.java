package com.piyali.justeat.service;

import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.User;
import com.piyali.justeat.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findByName(String username){
        return userRepository.findByUserName(username).orElseThrow(()->new NotFoundException("User not found"));
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User not found"));
    }
}