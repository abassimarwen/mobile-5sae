package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.Toy;

import java.util.List;

@Dao
public interface ToyDao {
    @Insert
    void insertOne(Toy toy);
    @Delete
    void delete(Toy toy);
    @Query("SELECT * FROM toy")
    List<Toy> getAll();
}
