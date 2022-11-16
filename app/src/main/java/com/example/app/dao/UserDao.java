package com.example.app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.app.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertOne(User user);
    @Delete
    void delete(User user);
    @Query("SELECT * FROM user")
    List<User> getAll();
}
