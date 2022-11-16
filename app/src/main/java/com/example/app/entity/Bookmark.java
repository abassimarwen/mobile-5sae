package com.example.app.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.TypeConverter;

import com.example.app.entity.enums.BookmarkStatus;

import java.time.LocalDateTime;

@Entity(tableName = "bookmark")
public class Bookmark {
    @ColumnInfo(name = "bookmark_status")
    private BookmarkStatus status;
    @ColumnInfo(name = "bookmark_createdAt")
    private LocalDateTime createdAt;
    @ColumnInfo(name = "bookmark_modifiedAt")
    private LocalDateTime modifiedAt;
}
