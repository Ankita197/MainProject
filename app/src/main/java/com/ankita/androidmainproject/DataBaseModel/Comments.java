package com.ankita.androidmainproject.DataBaseModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "comment")
public class Comments {
    @PrimaryKey(autoGenerate = true)
    private int commentid;

    @ColumnInfo(name = "food_id")
    private int foodid;

    @ColumnInfo(name = "user_name")
    private String user_name;

    @ColumnInfo(name = "comment")
    private String comment;

    public Comments(int commentid,int foodid,String user_name,String comment){
        this.commentid=commentid;
        this.foodid=foodid;
        this.user_name=user_name;
        this.comment=comment;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
