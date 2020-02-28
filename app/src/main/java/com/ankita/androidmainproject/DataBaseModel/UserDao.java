package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :first AND " +
            "password LIKE :password LIMIT 1")
    User findByName(String first, String password);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
