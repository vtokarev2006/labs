package com.lt.spring.labs.controllers;

import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.services.StockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping("{id:\\d}")
    public ResponseEntity<Stock> fetchById(@PathVariable @Valid long id) {
        return stockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Stock>> fetchAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Stock stock) {
        stockService.add(stock);
        return ResponseEntity.ok().build();
    }
}
