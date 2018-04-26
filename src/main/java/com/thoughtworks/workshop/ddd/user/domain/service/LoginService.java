package com.thoughtworks.workshop.ddd.user.domain.service;

import com.thoughtworks.workshop.ddd.exception.ResourceNotFoundException;
import com.thoughtworks.workshop.ddd.exception.UnauthorizedException;
import com.thoughtworks.workshop.ddd.persistence.user.UserRepositoryInMemory;
import com.thoughtworks.workshop.ddd.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class LoginService {

    @Autowired
    UserRepositoryInMemory userRepository;

    public void login(String email, String password) {
        User user = ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!user.isPassWordCorrect(password)) throw new UnauthorizedException("Login failed");
    }
}