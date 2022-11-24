package com.example.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BaseDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Base base);

    @Query("INSERT INTO Base (id, mainIngredient) VALUES (1, 'Мясо'), (2, 'Рыба'), (3, 'Овощи'), (4, 'Тесто')")
    void insertBaseData();

    @Delete
    void delete(Base base);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Base base);


    @Query("SELECT * FROM Base")
    List<Base> getAll();

}