package com.example.lab3;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MealTime{
    @PrimaryKey
    private int id;

    private String mealtime;

    public MealTime(int id, String mealtime){
        this.id = id;
        this.mealtime = mealtime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMealtime(String mealtime) {
        this.mealtime = mealtime;
    }

    public String getMealtime() {
        return mealtime;
    }
}

