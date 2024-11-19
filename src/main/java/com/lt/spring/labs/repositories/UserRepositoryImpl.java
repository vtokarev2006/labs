package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void add(User user) {

    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public Iterable<User> getAll() {
        return null;
    }
}
