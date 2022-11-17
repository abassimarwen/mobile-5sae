package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clothe")
public class Clothe extends Publication{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer id;

    @ColumnInfo(name="clothe_brand")
    private String brand;
    @ColumnInfo(name="clothe_size")
    private String size;

    public Clothe() {
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
