package com.example.outfitproject.model.controllers;

import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.repositories.*;
import com.example.outfitproject.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CategoryController {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    OccasionRepository occasionRepository;

    @Autowired
    WindRepository windRepository;


  @Autowired
  UserService userService;



    public void findAll(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("weather", weatherRepository.findAll());
        model.addAttribute("occasions", occasionRepository.findAll());
        model.addAttribute("winds", windRepository.findAll());
        model.addAttribute("page_title", "Add Category");
        model.addAttribute("process", "processcategory");
    }

    @GetMapping("/addcategory")
    public String categoryForm(Model model){
        findAll(model);
        model.addAttribute("object", new Category());
        return "type";
    }

    @PostMapping("/processcategory")
    public String processCategory(@Valid @ModelAttribute("object") Category category,
                                  BindingResult result,
                                  Model model) {
        findAll(model);
        if(result.hasErrors()){
            return "type";
        }
        boolean exist = categoryRepository.existsById(category.getId());
        if(exist) {
            ////////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            Category categoryDB = categoryRepository.findById(category.getId()).get();
            categoryDB.setName(category.getName().toLowerCase());
            categoryRepository.save(categoryDB);
            model.addAttribute("message", "Category Was Updated Successfully");
        }
        return  "redirect:/";





    }

































}
