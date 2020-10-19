package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Period;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeriodDto {
    private long id;
    private String name;

    public PeriodDto(Period period) {
        this.id = period.getId();
        this.name = period.getName();

    }
}
