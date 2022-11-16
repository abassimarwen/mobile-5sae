package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.Furniture;


import java.util.List;

@Dao
public interface FurnitureDao {
    @Insert
    void insertOne(Furniture furniture);
    @Delete
    void delete(Furniture furniture);
    @Query("SELECT * FROM furniture")
    List<Furniture> getAll();
}
