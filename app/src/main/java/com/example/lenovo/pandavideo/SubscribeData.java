package com.example.lenovo.pandavideo;

/**
 * Created by trung on 11/28/2016.
 */

public class SubscribeData {
    private int avatar;
    private String name;

    public SubscribeData(int avatar, String name) {
        //this.avatar = avatar;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAvatar() { return avatar;}
}
