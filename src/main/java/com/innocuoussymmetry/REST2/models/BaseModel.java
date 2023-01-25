package com.innocuoussymmetry.REST2.models;

import jakarta.persistence.*;

public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer newID) {
        this.id = newID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name= newName;
    }
}
