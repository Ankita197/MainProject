package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


@Entity(tableName = "entrees")
public class Entrees {
    private static ArrayList<Entrees> entree=new ArrayList<>();
    @PrimaryKey(autoGenerate = true)
    private int entreeid;
    @ColumnInfo(name="foodname")
    private String foodname;

    @ColumnInfo(name="price")
    private int price;

    @ColumnInfo(name="isVag")
    private boolean isVag;
    public Entrees(int entreeid, String foodname, int price, boolean isVag) {
        this.entreeid = entreeid;
        this.foodname = foodname;
        this.price = price;
        this.isVag = isVag;
        entree.add(this);
    }
   public static ArrayList<Entrees> returnList(){
      return entree;
   }
   public static int getSize(){
        return entree.size();
   }


    public int getEntreeid() {
        return entreeid;
    }

    public void setEntreeid(int entreeid) {
        this.entreeid = entreeid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isVag() {
        return isVag;
    }

    public void setVag(boolean vag) {
        isVag = vag;
    }
}
