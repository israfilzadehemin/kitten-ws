package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Responsibility;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponsibilityDto {
    private long id;
    private String name;

    public ResponsibilityDto(Responsibility responsibility) {
        this.id= responsibility.getId();
        this.name = responsibility.getName();
    }
}
