package com.kitten.kittenws.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long id;

    @Column(name = "contact_address")
    private String address;

    @Column(name = "contact_phone")
    private String phone;

    @Column(name = "contact_hours")
    private String hours;

    @Column(name = "contact_instagram")
    private String instagram;

    @Column(name = "contact_facebook")
    private String facebook;

    @Column(name = "contact_twitter")
    private String twitter;

    public Contact(String address, String phone, String hours, String instagram, String facebook, String twitter) {
        this.address = address;
        this.phone = phone;
        this.hours = hours;
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
    }
}
