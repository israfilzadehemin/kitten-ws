package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private long id;
    private String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
