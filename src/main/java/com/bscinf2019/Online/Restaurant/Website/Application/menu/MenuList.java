package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import com.bscinf2019.Online.Restaurant.Website.Application.restaurant.Restaurant;
import com.bscinf2019.Online.Restaurant.Website.Application.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.MAY;

@Configuration
public class MenuList {
    @Bean
    CommandLineRunner commandLineRunner(
            MenuItemRepository repository) {
        return args -> {
            MenuItem mphatso = new MenuItem(
                    1L,
                    "Mphatso",
                    "mphatsomphepo829@gmail.com",
                    "Burger",
                    15000.00
            );
            MenuItem thandie = new MenuItem(
                    2L,
                    "Thandie",
                    "Thandie@gmail.com",
                    "Half Chicken",
                    7600.00);

            repository.saveAll(
                    List.of(mphatso, thandie)
            );

        };
    }

}
