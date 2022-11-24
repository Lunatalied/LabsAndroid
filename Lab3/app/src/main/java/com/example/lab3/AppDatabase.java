package com.example.lab3;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Meals.class, Type.class, MealTime.class, Cuisine.class, Base.class}, version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MealsDao mealsDao();
    public abstract BaseDao baseDao();
    public abstract CuisineDao cuisineDao();
    public abstract MealTimeDao mealTimeDao();
    public abstract TypeDao typeDao();
}