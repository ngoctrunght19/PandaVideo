package com.example.lenovo.pandavideo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.pandavideo.SourceCode.CircleImage;

import java.util.List;

/**
 * Created by trung on 11/28/2016.
 */

public class SubscribeRecyclerViewAdapter extends RecyclerView.Adapter<SubscribeRecyclerViewAdapter.ViewHolder>{

    private List<SubscribeData> dataList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImage mImageView;
        public TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            mImageView = (CircleImage) view.findViewById(R.id.avatarSubscribe);
            mTitle = (TextView) view.findViewById(R.id.nameSubscribe);
        }

    }

    public SubscribeRecyclerViewAdapter(List<SubscribeData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_subscribe, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SubscribeData movie = dataList.get(position);
        holder.mTitle.setText(movie.getName());
        //holder.mImageView.setImageResource(movie.getAvatar());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
