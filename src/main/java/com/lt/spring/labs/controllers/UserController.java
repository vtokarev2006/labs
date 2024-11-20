package com.lt.spring.labs.controllers;

import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("{id}")
    public ResponseEntity<User> fetchById(@PathVariable Long id){
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    }

    @GetMapping
    public ResponseEntity<Iterable<User>> fetchAll(){
        return  ResponseEntity.ok(userService.findAll());

    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

}
