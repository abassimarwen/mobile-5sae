package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.Clothe;
import com.example.app.entity.Furniture;

import java.util.List;

@Dao
public interface ClotheDao {
    @Insert
    void insertOne(Clothe clothe);
    @Delete
    void delete(Clothe clothe);
    @Query("SELECT * FROM clothe")
    List<Clothe> getAll();
}
