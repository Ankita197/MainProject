package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CommentDao {
    @Query("SELECT * From comment")
    List<Comments> getAll();

    @Query("SELECT * FROM comment WHERE commentid IN (:commentids)")
    List<Comments> loadAllByIds(int[] commentids);

    @Insert
    void insertAll(Comments... comments);

    @Delete
    void delete(Comments comment);
}
