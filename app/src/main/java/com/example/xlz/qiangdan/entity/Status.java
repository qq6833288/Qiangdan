package com.example.xlz.qiangdan.entity;

/**
 * Created by xlz on 2016/5/25.
 */
public class Status {

    private String content;

    private String price;

    private String time;

    private String number;

    private String day;

    public Status(String content, String price, String time, String number, String day) {
        this.content = content;
        this.price = price;
        this.time = time;
        this.number = number;
        this.day = day;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
