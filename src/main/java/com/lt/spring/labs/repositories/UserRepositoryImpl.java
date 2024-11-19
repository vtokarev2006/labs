package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public static final String GET_ALL = "SELECT id, first_name, last_name FROM users";
    public static final String GET_BY_ID = "SELECT id, first_name, last_name FROM users where id=?";
    static final String ADD_USER = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update(ADD_USER, user.getFirstName(), user.getLastName());
    }

    @Override
    public Optional<User> get(Long id) {
        return jdbcTemplate.query(GET_BY_ID, getRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public Iterable<User> getAll() {
        return jdbcTemplate.query(GET_ALL, getRowMapper());
    }

    public static RowMapper<User> getRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            return user;
        };
    }
}
