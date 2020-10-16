package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
