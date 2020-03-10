package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String category_title);
}
