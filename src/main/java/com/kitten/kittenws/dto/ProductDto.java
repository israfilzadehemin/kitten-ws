package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String name;
    private double price;
    private ProducerDto producer;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.producer = new ProducerDto(product.getProducer());
    }
}
