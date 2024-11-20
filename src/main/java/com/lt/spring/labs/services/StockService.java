package com.lt.spring.labs.services;

import com.lt.spring.labs.entities.Stock;

import java.util.Optional;

public interface StockService {
    Stock add(Stock stock);
    Optional<Stock> findById(long id);
    Iterable<Stock> findAll();
}
