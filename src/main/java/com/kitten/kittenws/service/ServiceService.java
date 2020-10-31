package com.kitten.kittenws.service;

import com.kitten.kittenws.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public Optional<List<com.kitten.kittenws.entity.Service>> getAllServices() {
        return Optional.of(serviceRepository.findAll());
    }
}
