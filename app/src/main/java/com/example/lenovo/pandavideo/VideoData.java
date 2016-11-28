package com.example.lenovo.pandavideo;

/**
 * Created by lenovo on 11/27/2016.
 */
public class VideoData {
    private int mImage;
    private String mTitle;
    private String mAuthor;
    private String mInfo;

    public VideoData(int image, String title, String author, String info) {
        mImage = image;
        mTitle = title;
        mAuthor = author;
        mInfo = info;
    }

    public int getImage() {
        return mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getInfo() {
        return mInfo;
    }

}
