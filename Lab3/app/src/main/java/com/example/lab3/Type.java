package com.example.lab3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Type{
    @PrimaryKey
    private int id;

    private String type;

    public Type(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
