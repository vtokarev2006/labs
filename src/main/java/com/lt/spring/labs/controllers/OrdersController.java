package com.lt.spring.labs.controllers;

import com.lt.spring.labs.controllers.dto.PlaceOrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrdersController {

    @PostMapping
    public ResponseEntity<PlaceOrderDto> placeOrder(@RequestBody @Valid PlaceOrderDto placeOrderDto) {
        return ResponseEntity.ok(placeOrderDto);
    }
}
