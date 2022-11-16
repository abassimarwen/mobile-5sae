package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.example.app.entity.enums.BookmarkStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(tableName = "bookmark")
public class Bookmark {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private Integer id;

   /* @ColumnInfo(name = "bookmark_status")
    private BookmarkStatus status;*/
 /*   @ColumnInfo(name = "bookmark_createdAt")
    private Date createdAt;
    @ColumnInfo(name = "bookmark_modifiedAt")
    private Date modifiedAt;*/
    public Bookmark(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  /*  public BookmarkStatus getStatus() {
        return status;
    }

    public void setStatus(BookmarkStatus status) {
        this.status = status;
    }*/

  /*  public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }*/
}
