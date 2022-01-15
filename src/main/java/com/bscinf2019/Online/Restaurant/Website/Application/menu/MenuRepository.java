package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurant_Id(Long id);

    void delete(Long id);

    void deleteByRestaurant_Id(Long id);

}
