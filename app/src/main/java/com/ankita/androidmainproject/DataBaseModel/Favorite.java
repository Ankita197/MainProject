package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite")
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int favoriteid;

    @ColumnInfo(name = "foodid")
    private int entreeid;

    public Favorite(int entreeid) {

        this.entreeid = entreeid;
    }

    public int getFavoriteid() {
        return favoriteid;
    }

    public void setFavoriteid(int favoriteid) {
        this.favoriteid = favoriteid;
    }

    public void setEntreeid(int entreeid) {
        this.entreeid = entreeid;
    }

    public int getEntreeid() {
        return entreeid;
    }
}
