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

public class TabAccount extends Fragment {

    private List<AccountData> movieList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ItemRecyclerViewAdapter mAdapter;
    private boolean created = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_account, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerViewAccount);

        mAdapter = new ItemRecyclerViewAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        if(!created) prepareMovieData();
        return view;
    }


    private void prepareMovieData() {
        created = true;

        AccountData movie = new AccountData(R.drawable.ic_favorite_border_black_24px, "Yêu thích");
        movieList.add(movie);

        movie = new AccountData(R.drawable.ic_backup_black_24px, "Tải lên");
        movieList.add(movie);

        movie = new AccountData(R.drawable.ic_file_download_black_24px, "Tải về");
        movieList.add(movie);

        movie = new AccountData(R.drawable.ic_notifications_black_24px, "Thông báo");
        movieList.add(movie);

        movie = new AccountData(R.drawable.ic_history_black_24px, "Lịch sử");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
