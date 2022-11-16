package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "clothe")
public class Clothe {
    @ColumnInfo(name="clothe_brand")
    private String brand;
    @ColumnInfo(name="clothe_size")
    private String size;
}
