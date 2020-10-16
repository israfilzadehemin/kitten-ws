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
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resp_id")
    private long id;

    @Column(name = "resp_name")
    private String name;

    @ManyToMany(mappedBy = "responsibilities")
    private Set<Breed> breeds;

    @ManyToMany
    @JoinTable(
            name = "rel_resp_period",
            joinColumns = {@JoinColumn(name = "resp_id", referencedColumnName = "resp_id")},
            inverseJoinColumns = {@JoinColumn(name = "period_id", referencedColumnName = "period_id")}
    )
    private Set<Period> periods;

    public Responsibility(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsibility that = (Responsibility) o;
        return id == that.id &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
