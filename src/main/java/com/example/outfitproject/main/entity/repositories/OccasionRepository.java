package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Occasion;
import org.springframework.data.repository.CrudRepository;

public interface OccasionRepository extends CrudRepository<Occasion, Long> {
    Occasion findByName(String name);
}

