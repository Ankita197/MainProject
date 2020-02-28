package com.ankita.androidmainproject.model;

public class FavouriteData {
    private int image;
    private String foodName;
    private String foodType;
    private boolean isSelected = false;

    public FavouriteData(int image, String foodName, String foodType) {
        this.image = image;
        this.foodName = foodName;
        this.foodType = foodType;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
