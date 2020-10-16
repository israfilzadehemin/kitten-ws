package com.kitten.kittenws.service;

import com.kitten.kittenws.entity.Breed;
import com.kitten.kittenws.exception.NoBreedsException;
import com.kitten.kittenws.repository.BreedRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BreedService {
    private final BreedRepository breedRepository;

    public Page<Breed> getAllBreeds(Pageable page) {
        if (breedRepository.findAll(page).stream().count() == 0)
            throw new NoBreedsException();
        return breedRepository.findAll(page);

    }
}