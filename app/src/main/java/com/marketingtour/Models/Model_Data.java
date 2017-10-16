package com.marketingtour.Models;

/**
 * Created by ShanAli on 10/13/17.
 */

public class Model_Data {
    private String name;
    private int img_id;
    private String time;
    private String date;

    public Model_Data(String name, int img_id, String time, String date) {
        this.name = name;
        this.img_id = img_id;
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }
}
