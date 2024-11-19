package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.User;

interface UserRepository {
    void add(User user);
    User get(Long id);
    Iterable<User> getAll();
}
