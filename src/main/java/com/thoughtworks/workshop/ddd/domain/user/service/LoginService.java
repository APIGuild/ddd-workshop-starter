package com.thoughtworks.workshop.ddd.domain.user.service;

import static java.util.Optional.ofNullable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.user.model.User;
import com.thoughtworks.workshop.ddd.domain.user.repository.UserRepository;
import com.thoughtworks.workshop.ddd.exception.ResourceNotFoundException;
import com.thoughtworks.workshop.ddd.exception.UnauthorizedException;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public void login(String email, String password) {
        User user = ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.isPassWordCorrect(password)) {
            throw new UnauthorizedException("Login failed");
        }
    }
}
