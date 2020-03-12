package com.example.outfitproject.main.entity.repositories;


import com.example.outfitproject.main.entity.Climate;
import org.springframework.data.repository.CrudRepository;

public interface ClimateRepository extends CrudRepository<Climate, Long> {
    Climate findByName(String name);
}