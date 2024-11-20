package com.lt.spring.labs.services;

import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final StockRepository stockRepository;

    @Override
    public Stock add(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> findById(long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }
}
