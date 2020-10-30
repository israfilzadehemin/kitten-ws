package com.kitten.kittenws.dto;

import com.kitten.kittenws.entity.Contact;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ContactDto {
    private long id;
    private String address;
    private String phone;
    private String hours;
    private String instagram;
    private String facebook;
    private String twitter;

    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.address = contact.getAddress();
        this.phone = contact.getPhone();
        this.hours = contact.getHours();
        this.instagram = contact.getInstagram();
        this.facebook = contact.getFacebook();
        this.twitter = contact.getTwitter();
    }
}
