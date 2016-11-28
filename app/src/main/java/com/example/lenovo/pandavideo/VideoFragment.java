package com.example.lenovo.pandavideo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by trung on 11/24/2016.
 */

public class VideoFragment extends Fragment {

    private List<VideoData> videoList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private VideoRecyclerViewAdapter mAdapter;
    private boolean created = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewAccount);

        mAdapter = new VideoRecyclerViewAdapter(videoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        if(!created) prepareMovieData();
        return view;
    }

    private void prepareMovieData() {
        created = true;

        VideoData video = new VideoData(R.drawable.tristana_dragontrain, "Dragon Trainer Tristana | Login Screen - League of Legends",
                                    "League of Legends", "1 năm trước - 2k3 lượt xem");
        videoList.add(video);

        video = new VideoData(R.drawable.tdt_tristana, "Champion Spotlight: Tristana, the Yordle Gunner.",
                "League of Legends", "2 năm trước - 2k3 lượt xem");
        videoList.add(video);

        video = new VideoData(R.drawable.teemo_broken, "Dyrus • TEEMO BROKEN AHHHH!!",
                "Dyrus", "2 năm trước - 2k3 lượt xem");
        videoList.add(video);

        video = new VideoData(R.drawable.teemo_vs_renekton, "Best Teemo Korea vs Renekton TOP Ranked Challenger",
                "Lol Korean Pro Replays", "2 năm trước - 2k3 lượt xem");
        videoList.add(video);

        video = new VideoData(R.drawable.teemo_vs_vladimir, "League of Legends - Super Teemo vs Vladimir - S6 Ranked Gameplay (Season 6)",
                "Beastly Teemo", "2 năm trước - 2k3 lượt xem");
        videoList.add(video);

        mAdapter.notifyDataSetChanged();
    }
}
