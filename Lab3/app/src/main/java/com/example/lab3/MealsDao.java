package com.example.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import java.util.Map;

@Dao
public interface MealsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Meals meals);

    @Delete
    void delete(Meals meals);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Meals meals);

    @Query("SELECT * FROM Meals JOIN Base ON Meals.base = Base.id")
    Map<Meals, Base> joinBase();

    @Query("SELECT * FROM Meals JOIN Type ON Meals.type = Type.id")
    Map<Meals, Type> joinType();

    @Query("SELECT * FROM Meals JOIN MealTime ON Meals.mealTime = MealTime.id")
    Map<Meals, MealTime> joinMealTime();

    @Query("SELECT * FROM Meals")
    List<Meals> getAll();

}