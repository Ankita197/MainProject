package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoriteDao {
    @Query("SELECT * From favorite")
    List<Favorite> getAll();

    @Query("SELECT * FROM favorite WHERE foodid IN (:foodid)")
    Favorite getFavoriteById(int foodid);

    @Insert
    void insertAll(Favorite... favorites);

    @Delete
    void delete(Favorite favorite);

}
