package com.thoughtworks.workshop.ddd.domain.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.user.command.InitPasswordCommand;
import com.thoughtworks.workshop.ddd.domain.user.command.LoginCommand;
import com.thoughtworks.workshop.ddd.domain.user.command.RegisterCommand;
import com.thoughtworks.workshop.ddd.domain.user.model.User;
import com.thoughtworks.workshop.ddd.domain.user.repository.UserRepository;
import com.thoughtworks.workshop.ddd.domain.user.service.EmailService;
import com.thoughtworks.workshop.ddd.domain.user.service.LoginService;
import com.thoughtworks.workshop.ddd.domain.user.service.RegisterService;

@Service
public class UserApplicationService {
    private static Logger logger = LoggerFactory.getLogger(UserApplicationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Autowired
    EmailService emailService;

    @Autowired
    private RegisterService registerService;

    @Transactional
    public String register(RegisterCommand command) {
        User user = registerService.createUser(command.getOwnerEmail(), command.getPolicyNumber());
        String uuid = user.getUuid();
        userRepository.save(user);
        emailService.sendEmail(uuid);
        logger.info("Create user with email [{}]", command.getOwnerEmail());
        return uuid;
    }

    public void initPassword(InitPasswordCommand command) {
        User user = userRepository.findByUuid(command.getUuid());
        user.initPassWord(command.getPassword());
        logger.info("Set password with uuid[{}]", command.getUuid());
        userRepository.save(user);
    }

    public void login(LoginCommand command) {
        loginService.login(command.getEmail(), command.getPassword());
        logger.info("User login with email [{}]", command.getEmail());
    }
}
