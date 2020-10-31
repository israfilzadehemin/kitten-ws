package com.kitten.kittenws.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Service {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "service_id")
    private long id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "service_img")
    private String image;

    public Service(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
