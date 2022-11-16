package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pet")
public class Pet extends Publication{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer id;
    @ColumnInfo(name="pet_breed")
    private String breed;
    @ColumnInfo(name="pet_age")
    private Integer age;
    @ColumnInfo(name="pet_kind")
    private String kind;

    public Pet() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


}
