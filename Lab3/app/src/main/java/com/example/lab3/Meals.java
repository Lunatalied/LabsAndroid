package com.example.lab3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Meals implements Serializable {
    @PrimaryKey
    private Integer id;

    private String nameMeal;
    private Integer kkal;
    private Integer type;
    private Integer mealTime;
    private Integer cuisine;
    private Integer base;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNameMeal(String nameMeal) {
        this.nameMeal = nameMeal;
    }

    public String getNameMeal() {
        return nameMeal;
    }

    public void setKkal(Integer kkal) {
        this.kkal = kkal;
    }

    public Integer getKkal() {
        return kkal;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setMealTime(Integer mealTime) {
        this.mealTime = mealTime;
    }

    public Integer getMealTime() {
        return mealTime;
    }

    public void setCuisine(Integer cuisine) {
        this.cuisine = cuisine;
    }

    public Integer getCuisine() {
        return cuisine;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getBase() {
        return base;
    }
}