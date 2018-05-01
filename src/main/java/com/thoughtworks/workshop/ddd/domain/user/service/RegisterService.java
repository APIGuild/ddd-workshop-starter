package com.thoughtworks.workshop.ddd.domain.user.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.user.model.User;
import com.thoughtworks.workshop.ddd.domain.user.repository.UserRepository;
import com.thoughtworks.workshop.ddd.exception.BadRequestException;
import com.thoughtworks.workshop.ddd.exception.ResourceConflictException;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String email, String policyNumber) {
        if (userRepository.existByEmail(email)) throw new ResourceConflictException("Email exist");
        if (!validate(email, policyNumber)) throw new BadRequestException("PolicyNumber not correct");
        String uuid = UUID.randomUUID().toString();
        User user = new User(uuid, null, email);
        return user;
    }

    private boolean validate(String email, String policyNumber) {
        // TODO(policy): validate email and password
        return true;
    }

}
