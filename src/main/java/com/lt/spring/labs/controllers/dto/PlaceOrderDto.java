package com.lt.spring.labs.controllers.dto;

import com.lt.spring.labs.constraints.TradedStock;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PlaceOrderDto(@NotNull Long userId, @TradedStock String symbol, @Positive Integer quantity) {
}
