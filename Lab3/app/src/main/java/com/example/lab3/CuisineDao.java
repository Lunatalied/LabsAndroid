package com.example.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CuisineDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Cuisine cuisine);

    @Delete
    void delete(Cuisine cuisine);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Cuisine cuisine);

    @Query("SELECT * FROM Cuisine")
    List<Cuisine> getAll();
}