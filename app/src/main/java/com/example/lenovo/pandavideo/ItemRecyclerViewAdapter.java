package com.example.lenovo.pandavideo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by trung on 11/24/2016.
 */

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>{

    private List<AdapterData> dataList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.iconAccount);
            mTitle = (TextView) view.findViewById(R.id.mAccountItem);
        }

    }

    public ItemRecyclerViewAdapter(List<AdapterData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.account_item, parent, false);
        /*View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item, parent, false);*/

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AdapterData movie = dataList.get(position);
        holder.mTitle.setText(movie.getTitle());
        holder.mImageView.setImageResource(movie.getImageView());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
