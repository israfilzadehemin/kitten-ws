package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BreedRepository extends JpaRepository<Breed, Long> {
    Optional<List<Breed>> findByNameStartsWith(String letter);
}
