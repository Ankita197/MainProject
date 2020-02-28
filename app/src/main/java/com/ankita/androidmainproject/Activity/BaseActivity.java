package com.ankita.androidmainproject.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ankita.androidmainproject.DataBaseModel.AppDataBase;
import com.ankita.androidmainproject.SharedPreferenceStoreValue;

public class BaseActivity extends AppCompatActivity {
protected AppDataBase dataBase;
    protected SharedPreferenceStoreValue sharedPreferenceStoreValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferenceStoreValue = new SharedPreferenceStoreValue(getApplicationContext());
    }
}
