package com.ankita.androidmainproject;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceStoreValue {


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor myEdit;

    public SharedPreferenceStoreValue(Context context) {
        this.sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
    }

    public void storeValue(String phone_no) {
        myEdit.putString("phone_no", phone_no);
        myEdit.apply();
    }

    public String getValue() {
        return sharedPreferences.getString("phone_no", null);
    }
    public void clearSharedPreference(){
        myEdit.clear().apply();

    }
}

