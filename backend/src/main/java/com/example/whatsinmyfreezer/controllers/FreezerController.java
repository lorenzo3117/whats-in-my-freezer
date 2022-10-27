package com.example.whatsinmyfreezer.controllers;

import com.example.whatsinmyfreezer.entities.Freezer;
import com.example.whatsinmyfreezer.services.FreezerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freezers")
public class FreezerController {

    private final FreezerService service;

    private FreezerController(FreezerService service) {
        this.service = service;
    }

    @GetMapping("/user/{userId}")
    public List<Freezer> getAllForUserByUserId(@PathVariable Integer userId) {
        return service.getAllForUserByUserId(userId);
    }

    @PostMapping("/")
    public Freezer create(@RequestBody Freezer freezer) {
        return service.create(freezer);
    }
}
