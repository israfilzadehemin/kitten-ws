package com.kitten.kittenws.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_id")
    private long id;

    @Column(name = "about_name", length = 2500)
    private String name;

    public About(String name) {
        this.name = name;
    }
}
