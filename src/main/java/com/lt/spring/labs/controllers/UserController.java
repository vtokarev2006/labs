package com.lt.spring.labs.controllers;

import com.lt.spring.labs.entities.User;
import com.lt.spring.labs.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{id}")
    ResponseEntity<User> fetchById(@PathVariable Long id){
        return userRepository.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());    }

    @GetMapping
    ResponseEntity<Iterable<User>> fetchAll(){
        return  ResponseEntity.ok(userRepository.getAll());

    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
        userRepository.add(user);
        return ResponseEntity.ok().build();
    }

}
