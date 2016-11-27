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
 * Created by trung on 11/26/2016.
 */

public class TabHome extends Fragment {

    private List<HomeData> listData = new ArrayList<HomeData>();
    private RecyclerView mRecyclerView;
    private HomeRecylerViewAdapter mAdapter;
    private boolean created = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_view_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewHome);
        mAdapter = new HomeRecylerViewAdapter(listData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        if (created != true)prepareMovieData();
        return view;
    }

    private void prepareMovieData() {
        created = true;

        HomeData data = new HomeData(R.drawable.faded, "Alan Walker - Faded", "Alan Walker");
        listData.add(data);

        data = new HomeData(R.drawable.faded, "Alan Walker - Faded", "Alan Walker");
        listData.add(data);

        data = new HomeData(R.drawable.faded, "Alan Walker - Faded", "Alan Walker");
        listData.add(data);

        data = new HomeData(R.drawable.faded, "Alan Walker - Faded", "Alan Walker");
        listData.add(data);
    }
}
