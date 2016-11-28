package com.example.lenovo.pandavideo;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import java.lang.reflect.Field;


public class WatchVideoActivity extends AppCompatActivity {


    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    //lay danh sach cac video trong raw
    Field[] fields=R.raw.class.getFields();
    int curPos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_video);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Tạo bộ điều khiển
        if (mediaController == null) {
            System.out.println("a");
            videoView = (VideoView) findViewById(R.id.videoView);
            mediaController = new MediaController(WatchVideoActivity.this);

            // Gắn vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoView);

            // Sét đặt bộ điều khiển cho VideoView.
            videoView.setMediaController(mediaController);
        }


        try {
            // ID của file video.
            //int id = getId(curPos);
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lamnguoiyeuanhnhe));


        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoView.requestFocus();

        // Sự kiện khi file video sẵn sàng để chơi.
        videoView.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {


                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // Khi màn hình Video thay đổi kích thước
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Gắn lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });

        mediaController.setPrevNextListeners(new View.OnClickListener() {
            public void onClick(View v) {
                curPos = nextPos(curPos);
                int id = getId(curPos);
                Uri newVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + id);

                videoView.stopPlayback();
                videoView.setVideoURI(newVideoUri);
                videoView.start();
            }
        }, new View.OnClickListener() {
            public void onClick(View v) {
                curPos = prePos(curPos);
                int id = getId(curPos);
                Uri newVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + id);

                videoView.stopPlayback();
                videoView.setVideoURI(newVideoUri);
                videoView.start();
            }
        });


    }

    public int prePos(int pos) {
        if(pos == 0) return fields.length - 1;
        return pos - 1;
    }

    public int nextPos(int pos) {
        if(pos == fields.length - 1) return 0;
        return pos + 1;
    }

    // Tìm ID ứng với tên của file nguồn (Trong thư mục raw).
    public int getId(int pos) {
        try {
            int id = fields[pos].getInt(fields[pos]);
            return id;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return 0;
    }


//    public int getRawResIdByName(String resName) {
//        String pkgName = this.getPackageName();
//
//        // Trả về 0 nếu không tìm thấy.
//        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
//        return resID;
//    }


    // Lưu lại ví trí file video đang chơi.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }



    // Tạo lại ví trí file nhạc đang chơi.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
        videoView.start();
    }
}
