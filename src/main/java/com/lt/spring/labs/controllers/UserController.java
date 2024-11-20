package com.lt.spring.labs.controllers;

import com.lt.spring.labs.controllers.dto.NewUserDto;
import com.lt.spring.labs.entities.IdentifierType;
import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<User> fetchById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> fetchAll() {
        return ResponseEntity.ok(userService.findAll());

    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid NewUserDto newUserDto) {
        IdentifierType identifierType = IdentifierType.valueOf(StringUtils.upperCase(newUserDto.identifierType()));
        User user = User.builder()
                .firstName(newUserDto.firstName())
                .lastName(newUserDto.lastName())
                .emailAddress(newUserDto.emailAddress())
                .phoneNumber(newUserDto.phoneNumber())
                .countryOfResidence(newUserDto.countryOfResidence())
                .governmentIdentifier(newUserDto.governmentIdentifier())
                .balanceHeldOnAccount(newUserDto.balanceHeldOnAccount())
                .identifierType(identifierType)
                .build();
        userService.save(user);
        return ResponseEntity.ok().build();
    }

}
