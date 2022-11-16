package com.example.app.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.app.entity.Bookmark;
import com.example.app.entity.Clothe;
import com.example.app.entity.Furniture;
import com.example.app.entity.Pet;
import com.example.app.entity.SchoolSupplies;
import com.example.app.entity.Toy;
import com.example.app.entity.User;

@Database(entities = {User.class , Bookmark.class , Clothe.class , Furniture.class , Pet.class , SchoolSupplies.class , Toy.class}
        , version = 1
        , exportSchema = false)
public abstract class  AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
  /*  public abstract UserDao userDao();
    public abstract BookmarkDao bookmarkDao();
    public abstract ClotheDao clotheDao();
    public abstract FurnitureDao furnitureDao();
    public abstract PetDao petDao();
    public abstract SchoolSuppliesDao schoolSuppliesDao();
    public abstract ToyDao toyDao();*/
    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")

                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }
}
