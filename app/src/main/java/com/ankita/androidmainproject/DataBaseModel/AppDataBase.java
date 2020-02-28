package com.ankita.androidmainproject.DataBaseModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class,Entrees.class,Comments.class,Favorite.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase INSTANCE;
    public abstract UserDao userDao();
    public abstract CommentDao commentDao();
    public abstract EntreesDao entreesDao();
    public abstract FavoriteDao favoriteDao();
    public static AppDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "user-database").allowMainThreadQueries().build();
                        }
        return INSTANCE;
    }
    public static void destroyInstance(){
        INSTANCE = null;
    }

}
