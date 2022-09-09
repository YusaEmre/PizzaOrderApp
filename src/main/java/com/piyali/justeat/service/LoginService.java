package com.piyali.justeat.service;
import com.piyali.justeat.exception.InvalidUserCredentialsException;
import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.User;
import com.piyali.justeat.payload.request.LoginRequest;
import com.piyali.justeat.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateUser(LoginRequest loginRequest) {
       Optional<User> optionalUser = userRepository.findByUserNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
       if(!optionalUser.isPresent()){
           throw new InvalidUserCredentialsException("Wrong username or password");
       }else{
           return optionalUser.get().getAdmin();
       }
    }

}