package com.lt.spring.labs.repositories;

import com.lt.spring.labs.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
