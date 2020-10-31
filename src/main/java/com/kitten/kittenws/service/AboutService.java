package com.kitten.kittenws.service;

import com.kitten.kittenws.entity.About;
import com.kitten.kittenws.repository.AboutRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AboutService {
    private final AboutRepository aboutRepository;

    public Optional<List<About>> getAllAbouts() {
        return Optional.of(aboutRepository.findAll());
    }
}
