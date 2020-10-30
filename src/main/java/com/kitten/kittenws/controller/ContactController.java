package com.kitten.kittenws.controller;

import com.kitten.kittenws.dto.ContactDto;
import com.kitten.kittenws.exception.NoContactException;
import com.kitten.kittenws.service.CategoryService;
import com.kitten.kittenws.service.ContactService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/")
@AllArgsConstructor
public class ContactController {
    private final ContactService contactService;
    private final ModelMapper modelMapper;

    @GetMapping("/contacts")
    public ResponseEntity<?> getAllContacts() {
        return ResponseEntity.ok(
                contactService.getAllContacts()
                        .orElseThrow(NoContactException::new)
                        .stream()
                        .map(ContactDto::new)
                        .collect(Collectors.toList())
        );
    }
}
