package com.thoughtworks.workshop.ddd.user.repository;

import com.thoughtworks.workshop.ddd.user.domain.model.User;

public interface UserRepository {
    void save(User user);

    User findByUuid(String uuid);

    User findByEmail(String email);

    boolean existByEmail(String email);
}
