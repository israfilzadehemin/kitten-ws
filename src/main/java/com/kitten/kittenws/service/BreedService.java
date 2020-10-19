package com.kitten.kittenws.service;

import com.kitten.kittenws.entity.Breed;
import com.kitten.kittenws.exception.NoBreedsException;
import com.kitten.kittenws.repository.BreedRepository;
import com.kitten.kittenws.tool.ValidationTool;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BreedService {
    private final ValidationTool validationTool;

    private final BreedRepository breedRepository;

    public Optional<Page<Breed>> getAllBreeds(Pageable page) {
        return Optional.of( breedRepository.findAll(page));
    }

    public Optional<Breed> getBreedById(String id) {
        return breedRepository.findById(Long.parseLong(id));
    }
}