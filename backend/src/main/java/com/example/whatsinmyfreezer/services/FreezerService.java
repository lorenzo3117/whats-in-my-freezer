package com.example.whatsinmyfreezer.services;

import com.example.whatsinmyfreezer.entities.Freezer;
import com.example.whatsinmyfreezer.exceptions.NotFoundException;
import com.example.whatsinmyfreezer.repositories.FreezerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreezerService {

    private final FreezerRepository repository;

    private FreezerService(FreezerRepository repository) {
        this.repository = repository;
    }

    public Freezer getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Freezer not found"));
    }

    public List<Freezer> getAllForUserByUserId(Integer userId) {
        return repository.findAllByUserId(userId);
    }

    public Freezer create(Freezer freezer) {
        Freezer newFreezer = repository.save(freezer);
        return getById(newFreezer.getId());
    }
}
