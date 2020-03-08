package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
    Weather findByName(String name);
}
