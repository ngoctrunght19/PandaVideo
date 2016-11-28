package com.example.lenovo.pandavideo;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 11/27/2016.
 */

public class CreateDataForDemo extends Activity {
    private int[] mVideoImages;
    private String[] mVideoTitles;
    private String[] mVideoAuthors;
    private String FIXED_VIDEO_INFO = "1 ngày trước - 2k3 lượt xem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Resources res = getResources();
        mVideoTitles = res.getStringArray(R.array.video_title_array);
        mVideoAuthors = res.getStringArray(R.array.video_author_array);
        mVideoImages = res.getIntArray(R.array.video_image_array);
    }

    public List<VideoInfo> getVideoList() {
        List<VideoInfo> data = new ArrayList<>();

        for (int i = 0; i < mVideoAuthors.length; i++) {
            data.add(new VideoInfo(mVideoImages[i], mVideoTitles[i], mVideoAuthors[i], FIXED_VIDEO_INFO));
        }

        return data;
    }

}
