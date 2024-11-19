package com.lt.spring.labs.repositories;

import org.springframework.stereotype.Repository;

interface PortfolioRepository {
    void add(Repository repository);
    Repository get(Long id);
    Iterable<Repository> getAll();

}
