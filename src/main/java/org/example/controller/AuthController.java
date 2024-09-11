package org.example.controller;

import org.example.dto.CredentialsDto;
import org.example.dto.RegistrationDto;
import org.example.config.UserAuthProvider;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    public AuthController(UserService userService, UserAuthProvider userAuthProvider) {
        this.userService = userService;
        this.userAuthProvider = userAuthProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<org.example.entity.User> login(@RequestBody CredentialsDto credentials) {
        org.example.entity.User user = userService.login(credentials);

        user.setToken(userAuthProvider.createToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationDto registration) {
        org.example.entity.User user = userService.register(registration);

        user.setToken(userAuthProvider.createToken(user.getUsername()));
        return ResponseEntity.ok(user);
    }
}