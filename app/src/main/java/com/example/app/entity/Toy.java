package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "toy")
public class Toy extends Publication{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer id;
    @ColumnInfo(name="toy_brand")
    private String Brand;
    @ColumnInfo(name="toy_min_age_range")
    private Integer minAgeRange;
    @ColumnInfo(name="toy_max_age_range")
    private Integer maxAgeRange;

    public Toy() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public Integer getMinAgeRange() {
        return minAgeRange;
    }

    public void setMinAgeRange(Integer minAgeRange) {
        this.minAgeRange = minAgeRange;
    }

    public Integer getMaxAgeRange() {
        return maxAgeRange;
    }

    public void setMaxAgeRange(Integer maxAgeRange) {
        this.maxAgeRange = maxAgeRange;
    }
}
