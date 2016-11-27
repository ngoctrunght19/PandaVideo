package com.example.lenovo.pandavideo;

/**
 * Created by trung on 11/26/2016.
 */

public class HomeData {
    private int imageVideo;
    private String textTitle;
    private String textChannel;

    HomeData(int imageVideo, String textTitle, String textChannel){
        this.imageVideo = imageVideo;
        this.textTitle = textTitle;
        this.textChannel = textChannel;
    }

    public int getImageVideo() { return imageVideo; }

    public String getTextTitle() {
        return textTitle;
    }

    public String getTextChannel() {
        return textChannel;
    }

}
