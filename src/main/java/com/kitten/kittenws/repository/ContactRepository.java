package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
