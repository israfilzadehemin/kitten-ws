package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.About;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AboutDto {
    private long id;
    private String name;

    public AboutDto(About about) {
        this.id = about.getId();
        this.name = about.getName();
    }
}
