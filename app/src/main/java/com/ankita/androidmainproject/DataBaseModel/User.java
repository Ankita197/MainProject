package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "contact_no")
    private String contactNo;

    @ColumnInfo(name = "password")
    private String password;

    public User(int uid,String name, String contactNo, String password) {
        this.uid=uid;
        this.name = name;
        this.contactNo = contactNo;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        password = password;
    }
}
