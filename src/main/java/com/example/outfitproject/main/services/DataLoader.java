package com.example.outfitproject.main.services;

import com.example.outfitproject.main.entity.*;
import com.example.outfitproject.main.entity.repositories.*;
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
    ClimateRepository climateRepository;

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


///////////////////////////////////////Climate////////////////////////////////////////
        //Climate
        climateRepository.save(new Climate("cold"));
        Climate cold = climateRepository.findByName("cold");

        climateRepository.save(new Climate("moderate"));
        Climate mild = climateRepository.findByName("moderate");

        climateRepository.save(new Climate("hot"));
        Climate hot = climateRepository.findByName("hot");

        //////////////////////////////////Item///////////////////////////////////
        //@NotEmpty String name, @NotEmpty String color, @NotEmpty String fabricMaterial, @NotEmpty String size, @NotNull String picture, @NotNull String description, @NotNull String occasion, Category category, User user
        itemRepository.save(new Item("Dress Shirt","gray", "cotton", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583938457/shirt_yj6ysj.webp","Long leaves shirt","CASUAL",top,mild,jim));
        Item dresshirt = itemRepository.findByName("Dress Shirt");

        itemRepository.save(new Item("Pants","blue", "cotton", "32 * 34","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583939658/bluepants_k3lq2r.jpg","Dress blue pants","CASUAL",bottoms,mild,jim));
        Item bluepants = itemRepository.findByName("Pants");

        itemRepository.save(new Item("Light jacket","Brown", "polyester", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583939777/Belk_r5iaf4.jpg","This sleek jacket by London Fog® is ideal for wearing on or off of the course. Layer it over any polo shirt for a sophisticated finish.","CASUAL",jackets,mild,jim));
        Item lightJacket = itemRepository.findByName("Light jacket");

        itemRepository.save(new Item("Dressing Shoes","black", "Rubber", "12","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583779144/shoes-4887100_1920_stoqmc.jpg","Black dressing shoes","CASUAL",shoes,mild,jim));
        Item dressshoes = itemRepository.findByName("Dressing Shoes");

        itemRepository.save(new Item("Blue Dress Shirt","blue", "cotton", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940240/DRESS-SHIRT_afrmqq.jpg","Jetsetter Stretch Dress Shirt","CASUAL",top,mild,cris));
        Item dressshirt1 = itemRepository.findByName("Blue Dress Shirt");

        itemRepository.save(new Item("Wrinkle-Free Dress Chinos","Dark Khaki", "100% premium all-cotton twill", "32 * 34","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940413/262551_129_41_v0x1ev.jpg","They're made from premium, no-iron all-cotton twill, featuring a durable stain-resistant and wrinkle-free treatment that will last as long as your garment does. ","CASUAL",bottoms,mild,cris));
        Item khakipants = itemRepository.findByName("Wrinkle-Free Dress Chinos");

        itemRepository.save(new Item("Blue Light jacket","Blue", "polyester", "medium","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583940844/rBVaR1ugCPuACHQhAALg51jbpCQ705_g9cf91.jpg","2 Side Wear Men Jacket Embroidery Eagle Chest Logo Patch Men Bomber","CASUAL",jackets,mild,cris));
        Item bluelightJacket = itemRepository.findByName("Blue Light jacket");

        itemRepository.save(new Item("Dress Shoes","black", "Rubber", "11","https://res.cloudinary.com/di3jbt6xu/image/upload/v1583779144/photostockeditor-aEeN9ru_cu4-unsplash_aulkrm.jpg","Black dressing shoes","CASUAL",shoes,mild,cris));
        Item rubberdressshoes = itemRepository.findByName("Dres Shoes");




        itemRepository.save(new Item("Summer Man White Shirt","white", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584034290/Summer_Man_White_Shirt_ehevgn.jpg","Summer Man White Shirt","CASUAL",top, hot,jim));
        Item dresshirt1 = itemRepository.findByName("Summer Man White Shirt");

        itemRepository.save(new Item("Summer Man Blue Light Shirt","White", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584034456/Summer_Man_Light_Blue_Shirt_ffkcaf.jpg","Summer Man Blue Light Shirt","CASUAL",top, hot,jim));
        Item dresshirt2 = itemRepository.findByName("Summer Man Blue Light Shirt");

        itemRepository.save(new Item("Summer short pants","Khaki", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035165/Summer_Short_Pants_ejjxbp.jpg","Summer short pants","CASUAL",bottoms, hot,jim));
        Item drespants1 = itemRepository.findByName("Summer short pants");

        itemRepository.save(new Item("Summer Cotton Short Pants","dark blue", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035258/Summer_Cotton_Casual_pants_g1fa3f.jpg","Summer Cotton Short Pants","CASUAL",bottoms, hot,jim));
        Item drespants2 = itemRepository.findByName("Summer Cotton Short Pants");


        itemRepository.save(new Item("Summer Fabric Light Suit","white", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035819/Summer_Fabric_Light_Suit_hg5hqx.jpg","Summer Fabric Light Suit","CASUAL",top,hot,jim));
        Item dresjacket1 = itemRepository.findByName("Summer Fabric Light Suit");

        itemRepository.save(new Item("Summer Light Blue Suit","light blue", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035824/Summer_ligh-blue_suit_uswglm.png","Summer Light Blue Suit","CASUAL",top,hot,jim));
        Item dresjacket = itemRepository.findByName("Summer Light Blue Suit");


        itemRepository.save(new Item("Summer Sneakers","white", "leather", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035368/Summer-Sneakers-Men-Running_vhpujv.jpg","Summer Sneakers","CASUAL",shoes, hot,jim));
        Item dresshoes5 = itemRepository.findByName("Summer Sneakers");

        itemRepository.save(new Item("Summer Gray Sneakers","gray", "leather", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584035492/Summer_Gray_Sneakers_for_Men_nudeay.jpg","Summer Gray Sneakers","CASUAL",shoes, hot,jim));
        Item dresshoes1 = itemRepository.findByName("Summer Gray Sneakers");

        itemRepository.save(new Item("Winter Long sleeve Shirt","gray", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584031868/Winter_long_sleeve_for_men_urspzh.jpg","Winter Long sleeve Shirt","CASUAL",top, cold,jim));
        Item dresshirt4 = itemRepository.findByName("Winter Long sleeve Shirt");

        itemRepository.save(new Item("Modern Fit Long Sleeve Shirt","White", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584032180/White_Modern_Fit_Long_Sleeve_Shirt_cu3xbf.jpg","Modern Fit Long Sleeve Shirt","CASUAL",top, cold,jim));
        Item dresshirt3 = itemRepository.findByName("Modern Fit Long Sleeve Shirt");

        itemRepository.save(new Item("Winter casual pants","Khaki", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584031648/Winter_Pants_akxkoz.webp","Winter casual pants","CASUAL",bottoms, cold,jim));
        Item drespants = itemRepository.findByName("Winter casual pants");

        itemRepository.save(new Item("Winter Mens Jeans","dark blue", "Denim", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584033740/Winter_Mens_Jeans_qxbbbe.jpg","Winter Mens Jeans","CASUAL",bottoms, cold,jim));
        Item drespants4 = itemRepository.findByName("Winter Mens Jeans");

        itemRepository.save(new Item("Winter Casual Puffer Jacket","gray", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584032398/Winter_Puffer_Coat_Man_Jacket_ongq5x.jpg","Winter Casual Puffer Jacket","CASUAL",jackets, cold,jim));
        Item dresjacket3 = itemRepository.findByName("Winter Casual Puffer Jacket");

        itemRepository.save(new Item("Winter Men Jacket","green", "cotton", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584032659/Winter_Men_Jacket_vjrbk9.jpg","Winter Men Jacket","CASUAL",jackets,cold,jim));
        Item dresjacket4 = itemRepository.findByName("Winter Men Jacket");

        itemRepository.save(new Item("Winter Boots for Man","brown", "leather", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584032942/Winter_Boots_for_Man_awitsf.jpg","Winter Boots for Man","CASUAL",shoes,cold,jim));
        Item dresshoes = itemRepository.findByName("Winter Boots for Man");

        itemRepository.save(new Item("Winter Leather Shoes","gray", "leather", "medium","https://res.cloudinary.com/di5v2kyqq/image/upload/v1584033409/Winter_Shoes_for_Men_zj6fuq.jpg","Winter Leather Shoes","CASUAL",shoes, cold,jim));
        Item dresshoes4 = itemRepository.findByName("Winter Leather Shoes");

    }
}