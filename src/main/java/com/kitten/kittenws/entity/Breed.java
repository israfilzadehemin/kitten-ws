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
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breed_id")
    private long id;

    @Column(name = "breed_name")
    private String name;

    @Column(name = "breed_info")
    private String info;

    @Column(name = "breed_image")
    private String image;

    @ManyToOne
    @JoinTable(
            name = "rel_breed_category",
            joinColumns = {@JoinColumn(name = "breed_id", referencedColumnName = "breed_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "category_id")}
    )
    private Category category;

    @ManyToMany()
    @JoinTable(
            name = "rel_breed_characteristics",
            joinColumns = {@JoinColumn(name = "breed_id", referencedColumnName = "breed_id")},
            inverseJoinColumns = {@JoinColumn(name = "characteristics_id", referencedColumnName = "characteristics_id")}
    )
    private Set<Characteristics> characteristics;

    @ManyToMany
    @JoinTable(
            name = "rel_breed_responsibility",
            joinColumns = {@JoinColumn(name = "breed_id", referencedColumnName = "breed_id")},
            inverseJoinColumns = {@JoinColumn(name = "resp_id", referencedColumnName = "resp_id")}
    )
    private Set<Responsibility> responsibilities;

    @ManyToMany
    @JoinTable(
            name = "rel_breed_product",
            joinColumns = {@JoinColumn(name = "breed_id", referencedColumnName = "breed_id")},
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    )
    private Set<Product> products;


    public Breed(String name, String info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breed breed = (Breed) o;
        return id == breed.id &&
                name.equals(breed.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
