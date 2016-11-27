package com.example.lenovo.pandavideo;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
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

/**
 * Created by trung on 11/26/2016.
 */

public class TabHome extends Fragment {

    private List<HomeData> listData = new ArrayList<HomeData>();
    private RecyclerView mRecyclerView;
    private HomeRecyclerViewAdapter mAdapter;
    private boolean created = false;

    protected Handler handler;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //doi mau process bar luc bat dau vao app
        ProgressBar spinner = new android.widget.ProgressBar(getContext(), null, android.R.attr.progressBarStyle);
        spinner.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);

        View view = inflater.inflate(R.layout.fragment_tab_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewHome);
        handler = new Handler();
        if (created != true)prepareMovieData();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new HomeRecyclerViewAdapter(listData, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                //add null , so the adapter will check view_type and show progress bar at bottom
                listData.add(null);
                mAdapter.notifyItemInserted(listData.size() - 1);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //   remove progress item
                        listData.remove(listData.size() - 1);
                        mAdapter.notifyItemRemoved(listData.size());
                        //add items one by one
                        int start = listData.size();
                        int end = start + 5;

                        for (int i = start + 1; i <= end; i++) {
                            listData.add(new HomeData(R.drawable.lck, "LCK Spring - Week 10 Day 1", "LoL Esports"));
                            listData.add(new HomeData(R.drawable.lamnguoiyeuanhnhebaby, "Làm Người Yêu Anh Nhé Baby", "Nguyen Jenda"));
                            mAdapter.notifyItemInserted(listData.size());
                        }
                        mAdapter.setLoaded();
                        //or you can add all at once but do not forget to call mAdapter.notifyDataSetChanged();
                    }
                }, 5000);
            }
        });
        return view;
    }

    private void prepareMovieData() {
        created = true;

        HomeData data = new HomeData(R.drawable.lamnguoiyeuanhnhebaby, "Làm Người Yêu Anh Nhé Baby", "Nguyen Jenda");
        listData.add(data);

        data = new HomeData(R.drawable.minhlagicuanhau, "Mình là gì của nhau | Lou Hoàng | Official MV", "Year Music");
        listData.add(data);

        data = new HomeData(R.drawable.faded, "Alan Walker - Faded", "Alan Walker");
        listData.add(data);

        data = new HomeData(R.drawable.lck, "LCK Spring - Week 10 Day 1", "LoL Esports");
        listData.add(data);

        data = new HomeData(R.drawable.sktvsrox, "SK Telecom T1 vs Rox Tigers | Game 1 ...", "LoL Esports");
        listData.add(data);

        data = new HomeData(R.drawable.yasu, "Yasuo Montage - Community Montage 2016", "LoL Esports");
        listData.add(data);
    }
}
