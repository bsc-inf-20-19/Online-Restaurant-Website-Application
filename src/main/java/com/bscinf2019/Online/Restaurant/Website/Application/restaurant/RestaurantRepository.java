package com.bscinf2019.Online.Restaurant.Website.Application.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    void delete(Long id);
}
