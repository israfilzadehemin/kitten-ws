package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Product;
import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String name;
    private double price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
