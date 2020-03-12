package com.example.outfitproject.main.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//Hot Mild Cold
@Entity
public class Climate implements Serializable {

    private static final long serialVersionUID = 1L;



    @OneToMany(mappedBy = "climate", orphanRemoval = true)
    private Set<Item> items;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Column
    private String name;

    public Climate() {
        items = new HashSet<>();
    }

    public Climate(@NotEmpty String name) {
        this();
        this.name = name;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
