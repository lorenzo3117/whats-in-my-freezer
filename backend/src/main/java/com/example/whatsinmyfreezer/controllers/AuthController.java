package com.example.whatsinmyfreezer.controllers;

import com.example.whatsinmyfreezer.entities.Login;
import com.example.whatsinmyfreezer.entities.User;
import com.example.whatsinmyfreezer.exceptions.NotFoundException;
import com.example.whatsinmyfreezer.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    private AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public User login(@RequestBody Login login) {
        User user = service.getUser(login.getEmail());

        if (login.getPassword().equals(user.getPassword())) {
            return user;
        }

        throw new NotFoundException("Invalid credentials");
    }

    @PostMapping("register")
    public User login(@RequestBody User user) {
        return service.create(user);
    }
}
