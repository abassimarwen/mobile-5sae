package com.example.app.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.io.Serializable;
import java.util.Set;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int uid;
    private String userName;
    private String password;
    private String email;

    /*   @ColumnInfo(name = "user_publications")
       private Set<Publication> publications;
   */

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    /*  public Set<Publication> getPublications() {
        return publications;
    }
    public void setPublications(Set<Publication> publications) {
        this.publications = publications;
    }*/

    @NonNull
    public int getUid() {
        return uid;
    }

    public void setUid(@NonNull int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
