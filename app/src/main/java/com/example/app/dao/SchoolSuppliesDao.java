package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.SchoolSupplies;



import java.util.List;

@Dao
public interface SchoolSuppliesDao {
    @Insert
    void insertOne(SchoolSupplies schoolSupplies);
    @Delete
    void delete(SchoolSupplies schoolSupplies);
    @Query("SELECT * FROM school_supplies")
    List<SchoolSupplies> getAll();
}
