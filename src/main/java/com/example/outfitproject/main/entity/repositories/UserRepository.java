package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
