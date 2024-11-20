package com.lt.spring.labs.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public record NewUserDto(@NotBlank String firstName,
                         String lastName,
                         String emailAddress,
                         String phoneNumber,
                         String countryOfResidence,
                         String governmentIdentifier,
                         Long balanceHeldOnAccount,
                         String identifierType) {
}
