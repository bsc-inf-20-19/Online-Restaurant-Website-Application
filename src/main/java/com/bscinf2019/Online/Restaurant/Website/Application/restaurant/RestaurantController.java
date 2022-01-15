package com.bscinf2019.Online.Restaurant.Website.Application.restaurant;

import com.bscinf2019.Online.Restaurant.Website.Application.menu.Menu;
import com.bscinf2019.Online.Restaurant.Website.Application.menu.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository th;
    @Autowired
    private MenuRepository pa;

    @RequestMapping("/")
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = th.findAll();
        log.info("Fetch all: " + restaurants);
        return restaurants;
    }

    @RequestMapping("/{id}")
    public Optional<Restaurant> findRestaurantById(@PathVariable("id") Long id) {
        return th.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<Restaurant> restaurants) {
//        log.info("save restaurants: " + restaurants);
//        th.save(restaurants);
//    }
    public void upload(@RequestBody Restaurant restaurants) {
        log.info("save restaurants: " + restaurants);
        th.save(restaurants);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        log.info("Delete all restaurants ... ");
        th.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("delete restaurants by id ... ");
        th.delete(id);
    }

    @RequestMapping("/{id}/menus/")
    public List<Menu> getMenus(@PathVariable("id") Long id) {
        Optional<Restaurant> rest = th.findById(id);
        if (rest != null)
            return pa.findByRestaurant_Id(id);
        return new LinkedList<Menu>();
    }

    @PostMapping("/{id}/menus/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenus(@PathVariable("id") Long id, @RequestBody List<Menu> menus) {
        Optional<Restaurant> rest = th.findById(id);
        if (rest == null)
            return ;

        for(Menu m : menus){
            m.setRestaurant(m.getRestaurant());
            pa.save(m);
        }
    }

    @DeleteMapping("/{id}/menus/")
    public void deleteMenus(@PathVariable("id") Long id) {
        Optional<Restaurant> rest = th.findById(id);
        if (rest == null)
            return ;
        pa.deleteByRestaurant_Id(rest.get().getId());
    }

}
