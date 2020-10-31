package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Service;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ServiceDto {
    private long id;
    private String name;
    private String image;

    public ServiceDto(Service service) {
        this.id = service.getId();
        this.name = service.getName();
        this.image = service.getImage();
    }
}
