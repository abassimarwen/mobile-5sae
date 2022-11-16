package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "furniture")
public class Furniture {
    @ColumnInfo(name = "furniture_brand")
    private String brand;
}
