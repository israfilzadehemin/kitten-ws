package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.ServiceDto;
import com.kitten.kittenws.exception.NoServiceException;
import com.kitten.kittenws.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/")
@AllArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping("/services")
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(
                serviceService.getAllServices()
                        .orElseThrow(NoServiceException::new)
                        .stream()
                        .map(ServiceDto::new)
                        .collect(Collectors.toList())
        );
    }
}
