package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import com.bscinf2019.Online.Restaurant.Website.Application.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
    @Id
    @GeneratedValue

    private Long id;
    private String info;
    private String type;

    @OneToMany(mappedBy = "menu",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.EAGER)
    private java.util.List<MenuItem> items;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @JsonAnySetter
    public void setRestaurant(Restaurant restaurant){
        this.restaurant =
                restaurant;
    }

    @JsonAnyGetter
    public Restaurant getRestaurant(){
        return restaurant;
    }

    @JsonCreator
    public Menu(@JsonProperty("id") Long id,
                @JsonProperty("type") String type,
                @JsonProperty("info") String info,
                @JsonProperty("items") List<MenuItem> items){
        this.id = id;
        this.type = type;
        this.info = info;
        if (items != null){
            this.items = items;
            for (MenuItem item : items)
                item.setMenu(Optional.of(this));
        }
    }

    public Menu(Long id, String type, String info, Restaurant restaurant){
        this.id = id;
        this.type = type;
        this.info = info;
        this.restaurant = restaurant;
    }
    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", items=" + items +
                '}';
    }
}
