package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemRepository pam;

    @GetMapping("/")
    public List<MenuItem> getMenuItems(){
        return pam.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MenuItem> findMenuById(@PathVariable("id") Long id){
        return pam.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<MenuItem> menuItemList){
//        pam.save(menuItemList);
//    }
    public void upload(@RequestBody MenuItem menuItemList){
        pam.save(menuItemList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        pam.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        pam.delete(id);
    }
}
