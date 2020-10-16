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
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private long id;

    @Column(name = "period_name")
    private String name;

    @ManyToMany(mappedBy = "periods")
    private Set<Responsibility> responsibilities;

    public Period(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return id == period.id &&
                name.equals(period.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
