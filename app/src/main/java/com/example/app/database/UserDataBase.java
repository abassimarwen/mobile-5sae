package com.example.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.app.dao.UserDao;
import com.example.app.entity.User;


@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

   public abstract UserDao getUserDao ();
}
