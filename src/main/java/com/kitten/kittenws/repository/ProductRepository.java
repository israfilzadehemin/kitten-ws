package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
