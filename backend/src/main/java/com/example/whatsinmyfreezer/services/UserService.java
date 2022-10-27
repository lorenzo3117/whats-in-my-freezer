package com.example.whatsinmyfreezer.services;

import com.example.whatsinmyfreezer.entities.User;
import com.example.whatsinmyfreezer.exceptions.NotFoundException;
import com.example.whatsinmyfreezer.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    private UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUser(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User create(User user) {
        User newUser = repository.save(user);
        return getUser(newUser.getEmail());
    }
}
