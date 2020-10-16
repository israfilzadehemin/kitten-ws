package com.kitten.kittenws.repository;

import com.kitten.kittenws.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
