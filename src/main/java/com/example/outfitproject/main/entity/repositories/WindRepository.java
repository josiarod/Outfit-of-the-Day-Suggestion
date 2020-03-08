package com.example.outfitproject.main.entity.repositories;

import org.springframework.data.repository.CrudRepository;

public interface WindRepository extends CrudRepository<WindRepository, Long> {
    WindRepository findByName(String name);
}
