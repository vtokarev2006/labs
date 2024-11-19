package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.Portfolio;
import com.lt.spring.labs.entities.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository {
    private final JdbcTemplate jdbcTemplate;

    public PortfolioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Repository repository) {

    }

    @Override
    public Repository get(Long id) {
        return null;
    }

    @Override
    public Iterable<Repository> getAll() {
        return null;
    }

    public static RowMapper<Portfolio> getRowMapper() {
        return (rs, rowNum) -> {
            Portfolio portfolio = new Portfolio();
            portfolio.setId(rs.getLong("id"));
            portfolio.setName(rs.getString("name"));
            portfolio.setUserId(rs.getLong("userId"));
            return portfolio;
        };
    }

}
