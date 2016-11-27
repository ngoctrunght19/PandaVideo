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

public class ItemRecyclerViewFragment extends Fragment {

    private List<VideoInfo> videoList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ItemRecyclerViewHrAdapter mAdapter;
    private boolean created = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewAccount);

        mAdapter = new ItemRecyclerViewHrAdapter(videoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        if(!created) prepareMovieData();
        return view;
    }

    private void prepareMovieData() {
        created = true;

        VideoInfo video = new VideoInfo(R.drawable.penguins, "ba con chim canh cut canh cut",
                                    "internet", "1 nam truoc - 2k luot xem");
        videoList.add(video);
    //    videoList.add(video);
    //    videoList.add(video);
    //    videoList.add(video);
        videoList.add(video);

        mAdapter.notifyDataSetChanged();
    }
}
