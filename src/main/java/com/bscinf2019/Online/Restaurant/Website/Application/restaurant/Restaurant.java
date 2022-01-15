package com.bscinf2019.Online.Restaurant.Website.Application.restaurant;

import com.bscinf2019.Online.Restaurant.Website.Application.menu.Menu;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Restaurant {
    @GeneratedValue
    @Id

    private String name;
    private String location;
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Menu> menus;

    @JsonCreator
    public Restaurant(@JsonProperty("id") Long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("location") String location,
                      @JsonProperty("menus") List<Menu> menus){
        this.name = name;
        this.location = location;
        if (menus != null){
            this.menus = menus;
            for (Menu menu : menus)
                menu.setRestaurant(this);
        }
    }
    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }
}