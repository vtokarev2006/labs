package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
