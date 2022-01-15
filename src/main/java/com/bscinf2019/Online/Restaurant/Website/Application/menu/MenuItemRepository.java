package com.bscinf2019.Online.Restaurant.Website.Application.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository  extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByMenu_Id(Long id);

    void delete(Long id);
    @Autowired
    @Override
    <S extends MenuItem> S save(S entity);
}
