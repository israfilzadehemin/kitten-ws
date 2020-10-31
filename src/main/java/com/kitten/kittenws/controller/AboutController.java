package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.AboutDto;
import com.kitten.kittenws.exception.NoAboutException;
import com.kitten.kittenws.service.AboutService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/")
@AllArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping("/abouts")
    public ResponseEntity<?> getAllAbouts() {
        return ResponseEntity.ok(
                aboutService.getAllAbouts()
                        .orElseThrow(NoAboutException::new)
                        .stream()
                        .map(AboutDto::new)
                        .collect(Collectors.toList())
        );
    }
}
