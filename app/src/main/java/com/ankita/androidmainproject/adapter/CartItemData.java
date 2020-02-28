package com.ankita.androidmainproject.adapter;


public class CartItemData {
    private int imageid, btnplusid, btnminusid;
    private String title, subtitle;
    private int price;
    private int qty;


    public CartItemData(String title, String subtitle, int tvprice, int imageid, int btnminusid, int btnplusid, int qty) {
        this.btnminusid = btnminusid;
        this.btnplusid = btnplusid;
        this.price = tvprice;
        this.imageid = imageid;
        this.title = title;
        this.subtitle = subtitle;
        this.qty = qty;

    }

//    public static int getTVPrise() {
//        return tvprise;
//    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public int getBtnplusid() {
        return btnplusid;
    }

    public void setBtnplusid(int btnplusid) {
        this.btnplusid = btnplusid;
    }

    public int getBtnminusid() {
        return btnminusid;
    }

    public void setBtnminusid(int btnminusid) {
        this.btnminusid = btnminusid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
