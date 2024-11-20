package com.lt.spring.labs.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TradedStockValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TradedStock {

    String message() default "${validatedValue} is not a traded product";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
