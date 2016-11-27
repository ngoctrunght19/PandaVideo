package com.example.lenovo.pandavideo;

import android.widget.ImageView;

/**
 * Created by trung on 11/24/2016.
 */

public class AccountData {
    private int imageView;
    private String title;

    public AccountData(int imageView, String title) {
        this.imageView = imageView;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImageView() { return imageView;}
}
