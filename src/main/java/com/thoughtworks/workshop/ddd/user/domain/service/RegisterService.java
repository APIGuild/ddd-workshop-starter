package com.thoughtworks.workshop.ddd.user.domain.service;

import com.thoughtworks.workshop.ddd.exception.BadRequestException;
import com.thoughtworks.workshop.ddd.exception.ResourceConflictException;
import com.thoughtworks.workshop.ddd.persistence.user.UserRepositoryInMemory;
import com.thoughtworks.workshop.ddd.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterService {

    @Autowired
    private UserRepositoryInMemory userRepository;

    @Autowired
    EmailService emailService;

    public User createUser(String email, String policyNumber) {
        if (userRepository.existByEmail(email)) throw new ResourceConflictException("Email exist");
        if (!validate(email, policyNumber)) throw new BadRequestException("PolicyNumber not correct");
        String uuid = UUID.randomUUID().toString();
        User user = new User(uuid, null, email);
        userRepository.save(user);
        emailService.sendEmail(uuid);
        return user;
    }

    private boolean validate(String email, String policyNumber) {
        // TODO(policy): validate email and password
        return true;
    }

}
