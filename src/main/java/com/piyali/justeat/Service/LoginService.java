package com.piyali.justeat.Service;
import com.piyali.justeat.payload.request.LoginRequest;
import com.piyali.justeat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public boolean validateUser(LoginRequest loginRequest) {
       return userRepository.existsByUserNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
    }

}