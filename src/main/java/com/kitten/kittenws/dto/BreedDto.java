package com.kitten.kittenws.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kitten.kittenws.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
public class BreedDto {
    private long id;
    private String name;
    private String info;
    private String image;
    private CategoryDto category;
    private Set<CharacteristicsDto> characteristics = new HashSet<>();
    private Set<ResponsibilityDto> responsibilities = new HashSet<>();
    private Set<ProductDto> products = new HashSet<>();

    public BreedDto (Breed breed) {
        this.id = breed.getId();
        this.name = breed.getName();
        this.info = breed.getInfo();
        this.image = breed.getImage();
        this.category = new CategoryDto( breed.getCategory());
        breed.getCharacteristics().forEach(c -> this.characteristics.add(new CharacteristicsDto(c)));
        breed.getResponsibilities().forEach(r -> this.responsibilities.add(new ResponsibilityDto(r)));
        breed.getProducts().forEach(p -> this.products.add(new ProductDto(p)));
    }

}
