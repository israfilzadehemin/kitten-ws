package com.kitten.kittenws.service;

import com.kitten.kittenws.entity.Contact;
import com.kitten.kittenws.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public Optional<List<Contact>> getAllContacts() {
        return Optional.of(contactRepository.findAll());
    }
}
