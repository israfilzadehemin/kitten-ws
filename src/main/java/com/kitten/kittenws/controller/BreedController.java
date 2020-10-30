package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.BreedDto;
import com.kitten.kittenws.entity.Breed;
import com.kitten.kittenws.exception.BreedNotFoundException;
import com.kitten.kittenws.exception.NoBreedsException;
import com.kitten.kittenws.service.BreedService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@AllArgsConstructor
public class BreedController {
    private final BreedService breedService;
    private final ModelMapper modelMapper;

    @GetMapping("/api/1.0/breeds")
    public ResponseEntity<?> getAllBreeds(Pageable page) {
        return ResponseEntity.ok(breedService.getAllBreeds(page).orElseThrow(NoBreedsException::new).map(BreedDto::new));
    }

    @GetMapping("/api/1.0/breeds/{id}")
    public ResponseEntity<?> getBreedById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(modelMapper.map(
                breedService.getBreedById(id).orElseThrow(BreedNotFoundException::new),
                BreedDto.class)
        );
    }

    @GetMapping("/api/1.0/breeds/startswith")
    public ResponseEntity<?> getBreedsByFirstLetter(@RequestParam String letter) {
        return ResponseEntity.ok(breedService.getBreedsByFirstLetter(letter)
                .orElseThrow(BreedNotFoundException::new)
                .stream()
                .map(BreedDto::new)
                .collect(Collectors.toList()));
    }

}
