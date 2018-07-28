package com.example.tenx.test272.Activity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tenx.test272.R;

import Utils.EventsUtils;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.CustomViewholder>{

    private Context context;

    public NotificationsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_notif, parent, false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        holder.textView.setText(EventsUtils.notificationList[position]);

    }

    @Override
    public int getItemCount() {
        return EventsUtils.notificationList.length;
    }

    class CustomViewholder extends RecyclerView.ViewHolder{

        private TextView textView;
        private CustomViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.notification_textview);
        }
    }
}
