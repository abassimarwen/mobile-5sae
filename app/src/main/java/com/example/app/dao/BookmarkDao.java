package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.Bookmark;


import java.util.List;

@Dao
public interface BookmarkDao {
    @Insert
    void insertOne(Bookmark bookmark);
    @Delete
    void delete(Bookmark bookmark);
    @Query("SELECT * FROM bookmark")
    List<Bookmark> getAll();
}
