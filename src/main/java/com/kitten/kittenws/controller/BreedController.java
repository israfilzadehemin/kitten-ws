package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.BreedDto;
import com.kitten.kittenws.exception.BreedNotFoundException;
import com.kitten.kittenws.exception.NoBreedsException;
import com.kitten.kittenws.service.BreedService;
import com.kitten.kittenws.tool.ValidationTool;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@AllArgsConstructor
public class BreedController {
    private final BreedService breedService;
    private final ModelMapper modelMapper;
    private final ValidationTool validationTool;

    @GetMapping("/api/1.0/breeds")
    public Page<BreedDto> getAllBreeds(Pageable page) {
        return breedService.getAllBreeds(page).orElseThrow(() -> new NoBreedsException("/api/1.0/breeds")).map(BreedDto::new);
    }

    @GetMapping("/api/1.0/breeds/{id}")
    public ResponseEntity<?> getBreedById(@PathVariable(name = "id") String id) {
        validationTool.checkParsabilityToLong(id, "/api/1.0/breeds/{id}");
        return ResponseEntity.ok(modelMapper.map(
                breedService.getBreedById(id).orElseThrow(() -> new BreedNotFoundException("/api/1.0/breeds/{id}")),
                BreedDto.class)
        );
    }

}
