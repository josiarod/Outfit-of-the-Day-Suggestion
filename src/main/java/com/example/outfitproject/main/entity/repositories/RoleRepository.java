package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Role;
import com.example.outfitproject.main.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
