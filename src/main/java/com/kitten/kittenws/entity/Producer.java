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
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producer_id")
    private long id;

    @Column(name = "producer_name")
    private String name;

    public Producer(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "producer")
    Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id == producer.id &&
                name.equals(producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
