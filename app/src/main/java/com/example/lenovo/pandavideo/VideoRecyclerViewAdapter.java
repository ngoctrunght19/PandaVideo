package com.example.lenovo.pandavideo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 11/27/2016.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.ViewHolder> {

    private List<VideoData> mVideoList;

    public VideoRecyclerViewAdapter(List<VideoData> videoList) {
        mVideoList = videoList;
    }


    @Override
    public VideoRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VideoRecyclerViewAdapter.ViewHolder holder, int position) {
        VideoData video = mVideoList.get(position);
        holder.mTitle.setText(video.getTitle());
        holder.mImageView.setImageResource(video.getImage());
        holder.mAuthor.setText(video.getAuthor());
        holder.mInfo.setText(video.getInfo());
    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTitle;
        public TextView mAuthor;
        public TextView mInfo;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.videoImg);
            mAuthor = (TextView) view.findViewById(R.id.author);
            mTitle = (TextView) view.findViewById(R.id.title);
            mInfo = (TextView) view.findViewById(R.id.info);
        }

    }
}
