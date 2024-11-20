package com.lt.spring.labs.constraints;

import com.lt.spring.labs.entities.Stock;
import com.lt.spring.labs.services.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TradedStockValidator implements ConstraintValidator<TradedStock, String> {

    private final ProductService productService;
    private Set<String> tradedProducts = new HashSet<>();

    @Override
    public void initialize(TradedStock constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        tradedProducts = productService.findAll().stream().map(Stock::getSymbol).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return tradedProducts.contains(value);
    }
}