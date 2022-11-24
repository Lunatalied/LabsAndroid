package com.example.lab3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TypeDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Type type);

    @Delete
    void delete(Type type);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Type type);

    @Query("SELECT * FROM Type")
    List<Type> getAll();
}