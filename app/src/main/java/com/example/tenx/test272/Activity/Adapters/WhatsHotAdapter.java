package com.example.tenx.test272.Activity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.R;

import Utils.EventsUtils;

public class WhatsHotAdapter extends RecyclerView.Adapter<WhatsHotAdapter.CustomViewHolder>{


    private Context context;

    public WhatsHotAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_whatshot, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String imageUrl = EventsUtils.mainEventsImageUrl[position];
        Glide.with(context).load(imageUrl).apply(new RequestOptions().centerCrop()).into(holder.eventImage);
    }

    @Override
    public int getItemCount() {
        return EventsUtils.mainEventsImageUrl.length;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView eventImage;

        private CustomViewHolder(View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.event_image);
        }
    }
}
