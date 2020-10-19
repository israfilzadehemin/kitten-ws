package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Characteristics;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacteristicsDto {

    private long id;
    private String name;

    public CharacteristicsDto(Characteristics characteristics) {
        this.id = characteristics.getId();
        this.name = characteristics.getName();
    }
}
