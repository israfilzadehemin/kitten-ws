package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Characteristics;
import lombok.Data;

@Data
public class CharacteristicsDto {

    private long id;
    private String name;

    public CharacteristicsDto(Characteristics characteristics) {
        this.id = characteristics.getId();
        this.name = characteristics.getName();
    }
}
