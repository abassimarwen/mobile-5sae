package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.Pet;


import java.util.List;

@Dao
public interface PetDao {
    @Insert
    void insertOne(Pet pet);
    @Delete
    void delete(Pet pet);
    @Query("SELECT * FROM pet")
    List<Pet> getAll();
}
