package com.example.outfitproject.main.entity.repositories;

import com.example.outfitproject.main.entity.Category;
import com.example.outfitproject.main.entity.Item;
import com.example.outfitproject.main.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    //pagination

    Iterable<Item> findAllByCategory_Id(Long id);



    Item findByName(String name);

    Iterable<Item> findAllByUser(User user);

  Page<Item> findAllByUser(User user, org.springframework.data.domain.Pageable pageable);


  //////////////////////////////////////////////////////////

    Iterable<Item> findAllByCategory_IdAndUser(Long id, User user);




    List<Item> findAllByCategory(Category category);

    List<Item> findAllByCategoryAndUser(Category category,  User user);



    ////////////////////////////////////////////////////////////////////////

    Page<Item> findAllByNameContainingOrDescriptionContainingAllIgnoreCase(@NotEmpty String name, @NotNull String description, org.springframework.data.domain.Pageable pageable);

    Page<Item> findAllByUserAndNameContainingOrUserAndDescriptionContainingAllIgnoreCase(User user, @NotEmpty String name, User user2, @NotNull String description, org.springframework.data.domain.Pageable pageable);




}
