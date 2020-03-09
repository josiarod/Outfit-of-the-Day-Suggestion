package com.example.outfitproject.main.services;

import com.example.outfitproject.main.entity.Role;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.RoleRepository;
import com.example.outfitproject.main.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception{
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("jim@jim.com", "password", "Jim", "Jimmerson", "male", true, "jim", "photo1.jpg");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        User user1 = new User("cris@cris.com", "password", "Cris", "Reynoso", "male", true, "cris", "photo2.jpg");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user1);

        User user2 = new User("rey@rey.com", "password", "Rey", "Aponte", "male", true, "Rey", "photo3.jpg");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user2);

        User user3 = new User("aus@rey.com", "password", "Austin", "Wang", "male", true, "Aus", "photo5.jpg");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user3);

        user = new User("admin@admin.com", "password", "Admin", "User", "male", true, "admin", "photo4.jpg");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);
    }
}