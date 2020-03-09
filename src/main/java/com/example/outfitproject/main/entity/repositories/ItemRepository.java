package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.Item;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    //pagination
//
//    Iterable<Item> findAllByCategory_Id(Long id);
//
//    Iterable<Item> findAllByWeather_Id(Long id);
//
//    Iterable<Item> findAllByOccasion_Id(Long id);
//
//    Iterable<Item> findAllByWind_Id(Long id);
//
//    Item findByName(String name);
//
//    Iterable<Item> findAllByUser(User user);
//
//  Page<Item> findAllByUser(User user, Pageable pageable);
//
//
//  //////////////////////////////////////////////////////////
//
//    Iterable<Item> findAllByCategory_IdAndUser(Long id, User user);
//
//    Iterable<Item> findAllByWeather_IdAndUser(Long id, User user);
//
//    Iterable<Item> findAllByOccasion_IdAndUser(Long id, User user);
//
//    Iterable<Item> findAllByWind_IdAndUser(Long id, User user);
//
//    List<Item> findAllByCategoryAndWeather(Category category, Weather weather, User user);
//
//    List<Item> findAllByCategoryAndWeatherAndUser(Category category, Weather weather, User user);
//
//
//
//    ////////////////////////////////////////////////////////////////////////
//
//    Page<Item> findAllByNameContainingOrDescriptionContainingAllIgnoreCase(String title, String description, Pageable pageable);
//
//    Page<Item> findAllByUserAndNameContainingOrUserAndDescriptionContainingAllIgnoreCase(User user1, String title, User user, String description, Pageable pageable);




}
