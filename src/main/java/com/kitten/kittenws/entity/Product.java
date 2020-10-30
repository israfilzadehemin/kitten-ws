package com.kitten.kittenws.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private double price;

    @ManyToOne
    @JoinTable(
            name = "rel_producer_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "producer_id", referencedColumnName = "producer_id")}
    )
    private Producer producer;

    @ManyToMany(mappedBy = "products")
    Set<Breed> breeds;

    @ManyToOne()
    @JoinTable(
            name = "rel_category_product",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")}
    )
    private Category category;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
