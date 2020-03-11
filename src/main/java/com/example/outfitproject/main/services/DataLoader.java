package com.example.outfitproject.main.services;

import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.Item;
import com.example.outfitproject.main.entity.Role;
import com.example.outfitproject.main.entity.User;
import com.example.outfitproject.main.entity.repositories.CategoryRepository;
import com.example.outfitproject.main.entity.repositories.ItemRepository;
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
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception{
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User jim = new User("jim@jim.com", "password", "Jim", "Jimmerson", "male", true, "jim", "photo1.jpg");
        jim.setRoles(Arrays.asList(userRole));
        userRepository.save(jim);

        User cris = new User("cris@cris.com", "password", "Cris", "Reynoso", "male", true, "cris", "photo2.jpg");
        cris.setRoles(Arrays.asList(userRole));
        userRepository.save(cris);

        User rey = new User("rey@rey.com", "password", "Rey", "Aponte", "male", true, "Rey", "photo3.jpg");
        rey.setRoles(Arrays.asList(userRole));
        userRepository.save(rey);

        User aus= new User("aus@rey.com", "password", "Austin", "Wang", "male", true, "Aus", "photo5.jpg");
        aus.setRoles(Arrays.asList(userRole));
        userRepository.save(aus);

        User admin = new User("admin@admin.com", "password", "Admin", "User", "male", true, "admin", "photo4.jpg");
        admin.setRoles(Arrays.asList(adminRole));
        userRepository.save(admin);
        
        ////////////////////////Category//////////////////////////////////////////
        categoryRepository.save(new Category("top"));
        Category top = categoryRepository.findByName("top");

        categoryRepository.save(new Category("bottoms"));
        Category bottoms = categoryRepository.findByName("bottoms");

        categoryRepository.save(new Category("jackets"));
        Category jackets = categoryRepository.findByName("jackets");

        categoryRepository.save(new Category("shoes"));
        Category shoes = categoryRepository.findByName("shoes");

        //////////////////////////////////Item///////////////////////////////////
        //@NotEmpty String name, @NotEmpty String color, @NotEmpty String fabricMaterial, @NotEmpty String size, @NotNull String picture, @NotNull String description, @NotNull String occasion, Category category, User user
        itemRepository.save(new Item("Dress Shirt","gray", "cotton", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583938457/shirt_yj6ysj.webp","Long leaves shirt","CASUAL",top,jim));
        Item dresshirt = itemRepository.findByName("Dress Shirt");

        itemRepository.save(new Item("Pants","blue", "cotton", "32 * 34","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583939658/bluepants_k3lq2r.jpg","Dress blue pants","CASUAL",bottoms,jim));
        Item bluepants = itemRepository.findByName("Pants");

        itemRepository.save(new Item("Light jacket","Brown", "polyester", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583939777/Belk_r5iaf4.jpg","This sleek jacket by London Fog® is ideal for wearing on or off of the course. Layer it over any polo shirt for a sophisticated finish.","CASUAL",jackets,jim));
        Item lightJacket = itemRepository.findByName("Light jacket");

        itemRepository.save(new Item("Dressing Shoes","black", "Rubber", "12","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583779144/shoes-4887100_1920_stoqmc.jpg","Black dressing shoes","CASUAL",shoes,jim));
        Item dressshoes = itemRepository.findByName("Dressing Shoes");

        itemRepository.save(new Item("Blue Dress Shirt","blue", "cotton", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940240/DRESS-SHIRT_afrmqq.jpg","Jetsetter Stretch Dress Shirt","CASUAL",top,cris));
        Item dressshirt1 = itemRepository.findByName("Blue Dress Shirt");

        itemRepository.save(new Item("Wrinkle-Free Dress Chinos","Dark Khaki", "100% premium all-cotton twill", "32 * 34","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940413/262551_129_41_v0x1ev.jpg","They're made from premium, no-iron all-cotton twill, featuring a durable stain-resistant and wrinkle-free treatment that will last as long as your garment does. ","CASUAL",bottoms,cris));
        Item khakipants = itemRepository.findByName("Wrinkle-Free Dress Chinos");

        itemRepository.save(new Item("Blue Light jacket","Blue", "polyester", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940844/rBVaR1ugCPuACHQhAALg51jbpCQ705_g9cf91.jpg","2 Side Wear Men Jacket Embroidery Eagle Chest Logo Patch Men Bomber","CASUAL",jackets,cris));
        Item bluelightJacket = itemRepository.findByName("Blue Light jacket");

        itemRepository.save(new Item("Dress Shoes","black", "Rubber", "11","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583779144/photostockeditor-aEeN9ru_cu4-unsplash_aulkrm.jpg","Black dressing shoes","CASUAL",shoes,cris));
        Item rubberdressshoes = itemRepository.findByName("Dres Shoes");
    }
}