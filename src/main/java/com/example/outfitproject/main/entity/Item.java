package com.example.outfitproject.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotEmpty
    private String color;

    @NotEmpty
    private String fabricMaterial;

    @NotEmpty
    private String size;

    @NotNull
    private String picture;

    @NotNull
    private String description;

    @NotNull
    private String occasion;

    @ManyToOne
    private Category category;

    @ManyToOne(cascade=CascadeType.MERGE)
    private User user;


    public Item() {
        picture = "";
        user = new User();
        category = new Category();
    }


    public Item(@NotEmpty String name, @NotEmpty String color, @NotEmpty String fabricMaterial, @NotEmpty String size, @NotNull String picture, @NotNull String description, @NotNull String occasion, Category category, User user) {
        this.name = name;
        this.color = color;
        this.fabricMaterial = fabricMaterial;
        this.size = size;
        this.picture = picture;
        this.description = description;
        this.occasion = occasion;
        this.category = category;
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricMaterial() {
        return fabricMaterial;
    }

    public void setFabricMaterial(String fabricMaterial) {
        this.fabricMaterial = fabricMaterial;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
