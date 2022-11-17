package com.example.app.entity;






import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Publication {

    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="description")
    private String description;
  //  @ColumnInfo(name="image_url")
   // private String imageUrl;
  /*  @ColumnInfo(name="created_at")
    private Date createdAt;
    @ColumnInfo(name="modified_at")
    private Date modifiedAt;*/
 /*   @ColumnInfo(name= "publication_user")
    private User user;
    @ColumnInfo(name="publication_bookmark")
    private Bookmark bookmark;*/

    public Publication() {
       
    }

  /*  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  /*  public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
