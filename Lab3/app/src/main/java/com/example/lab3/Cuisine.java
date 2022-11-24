package com.example.lab3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cuisine{
    @PrimaryKey
    private int id;

    private String typeCuisine;

    public Cuisine (int id, String typeCuisine){
        this.id = id;
        this.typeCuisine = typeCuisine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTypeCuisine(String typeCuisine) {
        this.typeCuisine = typeCuisine;
    }

    public String getTypeCuisine() {
        return typeCuisine;
    }
}