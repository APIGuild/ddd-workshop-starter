package com.thoughtworks.workshop.ddd.user.domain.service;

import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class EmailService {
    public void sendEmail(String uuid) {
        System.out.println(format("UUID: %s", uuid));
    }
}
