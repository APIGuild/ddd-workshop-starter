package com.thoughtworks.workshop.ddd.persistence.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.thoughtworks.workshop.ddd.domain.user.model.User;
import com.thoughtworks.workshop.ddd.domain.user.repository.UserRepository;


@Repository
public class UserRepositoryInMemory implements UserRepository {
    private Map<String, User> userMap = new HashMap<>();

    public UserRepositoryInMemory() {
        userMap.put("123", new User("123", "password1", "email1"));
    }

    @Override
    public void save(User user) {
        userMap.put(user.getUuid(), user);
    }

    @Override
    public User findByUuid(String uuid) {
        return userMap.get(uuid);
    }

    @Override
    public User findByEmail(String email) {
        return userMap.values().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean existByEmail(String policyNumber) {
        return userMap.values().stream()
                .anyMatch(user -> policyNumber.equals(user.getEmail()));
    }
}
