package com.example.outfitproject.model.controllers;




import com.example.outfitproject.main.entity.Climate;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.CategoryRepository;
import com.example.outfitproject.main.entity.repositories.ClimateRepository;
import com.example.outfitproject.main.entity.repositories.ItemRepository;
import com.example.outfitproject.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



@Controller
public class ClimateController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ClimateRepository climateRepository;


    @Autowired
    UserService userService;

    public void findAll(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("climates", climateRepository.findAll());
        model.addAttribute("page_title", "Add Climate");
        model.addAttribute("process", "processclimate");
    }

    @GetMapping("/addclimate")
    public String climateForm(Model model) {
        model.addAttribute("climate", new Climate());
        return "categoryform";
    }


    @PostMapping("/process-climate")
    public String processClimate(@ModelAttribute Climate climate) {
        climateRepository.save(climate);
        return "redirect:/";
    }


    @RequestMapping("/detailclimate/{id}")
    public String showOutfitsByClimate(@PathVariable("id") long id, Model model) {
        findAll(model);
        User user = userService.getUser();
        model.addAttribute("page_title", climateRepository.findById(id).get().getName());

        if (user != null) {
            if (userService.isUser()) {
                model.addAttribute("items", itemRepository.findAllByClimate_IdAndUser(id, user));
            }
            if (userService.isAdmin()) {
                model.addAttribute("items", itemRepository.findAllByClimate_Id(id));
            }
        } else {
            model.addAttribute("items", itemRepository.findAllByClimate_Id(id));
        }
        return "weatherDetails";
    }

    @RequestMapping("/deleteclimate/{id}")
    public String deleteClimate(@PathVariable("id") long id) {
        climateRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/updateclimate/{id}")
    public String updateItem(@PathVariable("id") long id, Model model) {
        findAll(model);
        model.addAttribute("page_title", "Update Climate");
        model.addAttribute("object", climateRepository.findById(id).get());
        return "categoryform";
    }


}