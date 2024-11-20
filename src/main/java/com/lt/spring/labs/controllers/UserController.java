package com.lt.spring.labs.controllers;

import com.lt.spring.labs.controllers.dto.CreateUserDto;
import com.lt.spring.labs.controllers.dto.MyMapper;
import com.lt.spring.labs.entities.IdentifierType;
import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MyMapper mapper;


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
    public ResponseEntity<Void> create(@RequestBody CreateUserDto createUserDto) {
        IdentifierType identifierType = IdentifierType.valueOf(StringUtils.upperCase(createUserDto.getIdentifierType()));
        User user = mapper.map(createUserDto, User.class, "identifierType");
        user.setIdentifierType(identifierType);
        userService.save(user);
        return ResponseEntity.ok().build();
    }

}
