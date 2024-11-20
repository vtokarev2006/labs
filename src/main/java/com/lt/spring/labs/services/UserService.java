package com.lt.spring.labs.services;

import com.lt.spring.labs.entities.User;

import java.util.Optional;

public interface UserService {
    User addUser(User user);

    Optional<User> findById(long id);

    Iterable<User> findAll();

    User save(User user);
}
