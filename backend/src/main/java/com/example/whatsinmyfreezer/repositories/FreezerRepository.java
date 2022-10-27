package com.example.whatsinmyfreezer.repositories;

import com.example.whatsinmyfreezer.entities.Freezer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FreezerRepository extends JpaRepository<Freezer, Integer> {

    @Query("SELECT f FROM Freezer f WHERE f.user_id = ?1")
    List<Freezer> findAllByUserId(Integer userId);
}

