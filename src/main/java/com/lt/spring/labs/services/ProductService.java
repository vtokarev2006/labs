package com.lt.spring.labs.services;

import com.lt.spring.labs.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Stock add(Stock stock);
    Optional<Stock> findById(long id);
    List<Stock> findAll();
}
