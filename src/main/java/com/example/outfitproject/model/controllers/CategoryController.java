package com.example.outfitproject.model.controllers;




import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.CategoryRepository;
import com.example.outfitproject.main.entity.repositories.ItemRepository;
import com.example.outfitproject.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserService userService;

    public void findAll(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());



        model.addAttribute("page_title", "Add Category");
        model.addAttribute("process", "processcategory");
    }

    @GetMapping("/add-category")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/process-category")
    public String processCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/";
    }




    @RequestMapping("/detailcategory/{id}")
    public String showOutfitsByCategory(@PathVariable("id") long id, Model model) {
        findAll(model);
        User user = userService.getUser();
        model.addAttribute("page_title", categoryRepository.findById(id).get().getName());

        if (user != null) {
            if (userService.isUser()) {
                model.addAttribute("items", itemRepository.findAllByCategory_IdAndUser(id, user));
            }
            if (userService.isAdmin()) {
                model.addAttribute("items", itemRepository.findAllByCategory_Id(id));
            }
        } else {
            model.addAttribute("items", itemRepository.findAllByCategory_Id(id));
        }
        return "detaillist";
    }

    @RequestMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        categoryRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/updatecategory/{id}")
    public String updateItem(@PathVariable("id") long id, Model model) {
        findAll(model);
        model.addAttribute("page_title", "Update Category");
        model.addAttribute("object", categoryRepository.findById(id).get());
        return "categoryform";
    }


}

