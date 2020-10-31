package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
