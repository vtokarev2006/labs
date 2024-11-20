package com.lt.spring.labs.controllers;

import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stocks")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("{id:\\d}")
    public ResponseEntity<Stock> fetchById(@PathVariable @Valid long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Stock>> fetchAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Stock stock) {
        productService.add(stock);
        return ResponseEntity.ok().build();
    }
}
