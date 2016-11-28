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
 * Created by trung on 11/28/2016.
 */

public class SubscribeFragment extends Fragment {

    private List<SubscribeData> movieList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SubscribeRecyclerViewAdapter mAdapter;
    private boolean created = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscribe, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewSubscribe);

        mAdapter = new SubscribeRecyclerViewAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        if(!created) prepareMovieData();
        return view;
    }


    private void prepareMovieData() {
        created = true;

        SubscribeData movie = new SubscribeData(0, "LoL Replay");
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}