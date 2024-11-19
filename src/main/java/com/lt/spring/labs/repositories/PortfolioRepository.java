package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.Portfolio;
import org.springframework.data.repository.CrudRepository;

interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

}
