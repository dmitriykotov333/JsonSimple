package com.onpu.jsonsimple.Recycler;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.onpu.jsonsimple.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Item> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public String string;

        public MyViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.action_image);
        }
    }

    public Adapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Item movie = itemList.get(position);
        Picasso.get().load(movie.getText()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}