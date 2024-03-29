package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Producer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProducerDto {
    private long id;
    private String name;

    public ProducerDto(Producer producer) {
        this.id = producer.getId();
        this.name = producer.getName();
    }
}
