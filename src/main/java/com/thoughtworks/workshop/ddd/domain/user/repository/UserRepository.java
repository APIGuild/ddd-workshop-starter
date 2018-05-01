package com.thoughtworks.workshop.ddd.domain.user.repository;

import com.thoughtworks.workshop.ddd.domain.user.model.User;

public interface UserRepository {
    void save(User user);

    User findByUuid(String uuid);

    User findByEmail(String email);

    boolean existByEmail(String email);
}
