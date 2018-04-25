package com.thoughtworks.workshop.ddd.user;

import com.thoughtworks.workshop.ddd.persistence.user.UserRepositoryInMemory;
import com.thoughtworks.workshop.ddd.user.command.InitPasswordCommand;
import com.thoughtworks.workshop.ddd.user.command.LoginCommand;
import com.thoughtworks.workshop.ddd.user.command.RegisterCommand;
import com.thoughtworks.workshop.ddd.user.domain.model.User;
import com.thoughtworks.workshop.ddd.user.domain.service.LoginService;
import com.thoughtworks.workshop.ddd.user.domain.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    private static Logger logger = LoggerFactory.getLogger(UserApplicationService.class);

    @Autowired
    private UserRepositoryInMemory userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    public String register(RegisterCommand command) {
        User user = registerService.createUser(command.getOwnerEmail(), command.getPolicyNumber());
        logger.info("Create user with email [{}]", command.getOwnerEmail());
        return user.getUuid();
    }

    public void initPassword(InitPasswordCommand command) {
        User user = userRepository.findByUuid(command.getUuid());
        user.setPassWord(command.getPassword());
        logger.info("Set password with uuid[{}]", command.getUuid());
        userRepository.save(user);
    }

    public void login(LoginCommand command) {
        loginService.login(command.getEmail(), command.getPassword());
        logger.info("User login with email [{}]", command.getEmail());
    }
}
