package com.example.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MealTimeDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MealTime mealTime);

    @Delete
    void delete(MealTime mealTime);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(MealTime mealTime);

    @Query("SELECT * FROM MealTime")
    List<MealTime> getAll();
}