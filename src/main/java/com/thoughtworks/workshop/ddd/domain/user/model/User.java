package com.thoughtworks.workshop.ddd.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uuid;
    private String passWord;
    private String email;

    public boolean isPassWordCorrect(String password) {
        return this.passWord.equals(password);
    }
}
