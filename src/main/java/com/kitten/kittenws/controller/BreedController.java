package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.BreedDto;
import com.kitten.kittenws.entity.Breed;
import com.kitten.kittenws.service.BreedService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
public class BreedController {
    private final BreedService breedService;

    @GetMapping("/api/1.0/breeds")
    public Page<BreedDto> getAllBreeds(Pageable page) {
        return breedService.getAllBreeds(page).map(BreedDto::new);
    }

}
