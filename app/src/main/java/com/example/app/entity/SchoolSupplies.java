package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "school_supplies")
public class SchoolSupplies extends Publication{
    @ColumnInfo(name="school_supplies_brand")
    private String brand;
    @ColumnInfo(name="school_supplies_max_age_range")
    private Integer maxAgeRange;

}
