package com.example.lenovo.pandavideo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by trung on 11/26/2016.
 */

public class HomeRecylerViewAdapter extends RecyclerView.Adapter<HomeRecylerViewAdapter.HomeViewHolder> {

    private List<HomeData> listData;

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageVideo;
        public TextView textTitle;
        public TextView textChannel;

        public HomeViewHolder(View view) {
            super(view);
            imageVideo = (ImageView) view.findViewById(R.id.imageVideo);
            textTitle = (TextView) view.findViewById(R.id.textTitle);
            textChannel = (TextView) view.findViewById(R.id.textChannel);
        }

    }

    public HomeRecylerViewAdapter(List<HomeData> listData) {this.listData = listData;}

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card_view_home, parent, false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        HomeData homeData = listData.get(position);
        holder.imageVideo.setImageResource(homeData.getImageVideo());
        holder.textTitle.setText(homeData.getTextTitle());
        holder.textChannel.setText("By " + homeData.getTextChannel());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
