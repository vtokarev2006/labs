package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.User;

import java.util.Optional;

public interface UserRepository {
    void add(User user);
    Optional<User> get(Long id);
    Iterable<User> getAll();
}
