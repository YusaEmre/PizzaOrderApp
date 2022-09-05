package com.piyali.justeat.service;

import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.User;
import com.piyali.justeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User findByName(String username){
        return userRepository.findByUserName(username).orElseThrow(()->new NotFoundException("User not found"));
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User not found"));
    }
}