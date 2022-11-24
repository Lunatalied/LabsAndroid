package com.example.lab3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Base{
    @PrimaryKey
    private int id;

    private String mainIngredient;

    public Base(int id, String mainIngredient) {
        this.id = id;
        this.mainIngredient = mainIngredient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }
}

