package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EntreesDao {
    @Query("SELECT * From entrees")
    List<Entrees> getAll();

    @Query("SELECT * FROM entrees WHERE entreeid IN (:entreesid)")
    List<Entrees> loadAllByIds(int[] entreesid);

    @Insert
    void insertAll(Entrees... entrees);

    @Delete
    void delete(Entrees entrees);
}
