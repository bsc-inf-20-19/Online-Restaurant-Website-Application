package com.bscinf2019.Online.Restaurant.Website.Application.restaurant;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant {
    @GeneratedValue
    @Id

    private String name;
    private String location;
    private Long id;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }
}