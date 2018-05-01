package com.thoughtworks.workshop.ddd.domain.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String uuid;
    private String password;
    private String email;

    public User(String uuid, String password, String email) {
        this.uuid = uuid;
        this.password = password;
        this.email = email;
    }

    public void initPassWord(String password) {
        this.password = password;
    }

    public boolean isPassWordCorrect(String password) {
        return this.password.equals(password);
    }
}
