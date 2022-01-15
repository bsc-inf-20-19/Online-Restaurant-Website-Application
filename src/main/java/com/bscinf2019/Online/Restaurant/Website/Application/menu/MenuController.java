package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuRepository pa;

    @Autowired
    private MenuItemRepository pam;
    private Menu MenuList;

    public MenuController(Menu menuList) {
        MenuList = menuList;
    }

    @GetMapping("/")
    public List<Menu> getMenus() {
        return pa.findAll();
    }

    @GetMapping("/{id}")
    public Menu findMenuById(@PathVariable("id") Long id) {
        return pa.getOne(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Menu> menuList) {
        pa.save(MenuList);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        log.info("Delete all menus: ");
        pa.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        log.info("Delete menu by id :" + id);
        pa.delete(id);
    }

    @RequestMapping("/{id}/items/")
    public List<MenuItem> getItems(@PathVariable("id") Long id) {
        Menu menu = pa.getById(id);
        if (menu == null)
            return null;
        return pam.findByMenu_Id(id);
    }

    @PostMapping("/{id}/items/")
    public void addItems(@PathVariable("id") Long id,@RequestBody List<MenuItem> items) {
        Optional<Menu> menu = pa.findById(id);
        if (menu == null)
            return ;

        for (MenuItem item : items) {
            item.setMenu(menu);
            pam.save(item);
        }
    }
}
