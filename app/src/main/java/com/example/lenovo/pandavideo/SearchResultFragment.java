package com.example.lenovo.pandavideo;


import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;


public class SearchResultFragment extends Fragment {

    private List<VideoInfo> videoList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ItemRecyclerViewHrAdapter mAdapter;
    private boolean created = false;

    ProgressBar mProgressBar;

    public SearchResultFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ProgressBar spinner = new android.widget.ProgressBar(getContext(), null, android.R.attr.progressBarStyle);

        spinner.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        View view = inflater.inflate(R.layout.fragment_search_result, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.search_result_recycler);
        mAdapter = new ItemRecyclerViewHrAdapter(videoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mProgressBar = (ProgressBar) view.findViewById(R.id.searching_process);

        return view;
    }

    public void done() {
        mProgressBar.setVisibility(View.GONE);
    }

    public void start() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hide() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    public void show() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void loadData() {
        prepareMovieData();
    }

    private void prepareMovieData() {
        created = true;

        VideoInfo video = new VideoInfo(R.drawable.penguins, "ba con chim canh cut canh cut",
                "internet", "1 nam truoc - 2k luot xem");
        videoList.add(video);
        videoList.add(video);
        videoList.add(video);
        videoList.add(video);
        videoList.add(video);

        mAdapter.notifyDataSetChanged();
    }
}
