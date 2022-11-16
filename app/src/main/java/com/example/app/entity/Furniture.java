package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "furniture")
public class Furniture {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer id;
    @ColumnInfo(name = "furniture_brand")
    private String brand;

    public Furniture() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
