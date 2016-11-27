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

        data = new HomeData(R.drawable.lck, "LCK Spring - Week 10 Day 1", "LoL Esports");
        listData.add(data);

        data = new HomeData(R.drawable.sktvsrox, "SK Telecom T1 vs Rox Tigers | Game 1 ...", "LoL Esports");
        listData.add(data);

        data = new HomeData(R.drawable.minhlagicuanhau, "Mình là gì của nhau | Lou Hoàng | Official MV", "Year Music");
        listData.add(data);
    }
}
