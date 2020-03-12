package com.example.outfitproject.main.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    //orphanRemoval attribute can be used to specify that orphaned entities should be removed
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    public Set<Item> items;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    @CollectionTable
    private String name;

    public Category() {
        items = new HashSet<>();
    }
    public Category(@NotEmpty String name){
        //invoke current class constructor.
        this();
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
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
}
