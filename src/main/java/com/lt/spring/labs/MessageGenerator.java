package com.lt.spring.labs;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageGenerator {
    public String getMessage() {
        return LocalDateTime.now().getHour() < 12 ? "Good morning" : "Good afternoon";
    }
}
