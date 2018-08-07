package com.example.tenx.test272.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tenx.test272.DatabaseElements.Models.Notification;
import com.example.tenx.test272.R;

import java.util.List;

import com.example.tenx.test272.Utils.EventsUtils;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.CustomViewholder>{

    private Context context;
    private List<Notification> mList;

    public NotificationsAdapter(Context context) {
        this.context = context;
        /*this.mList = mList;*/
    }

    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_notif, parent, false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
        holder.textView.setText(mList.get(position).getmText());

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class CustomViewholder extends RecyclerView.ViewHolder{

        private TextView textView;
        private CustomViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.notification_textview);
        }
    }

    public  void insertAndRefresh(final List<Notification> list){
        if(mList==null){
            this.mList = list;
        }else{
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mList.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mList.get(oldItemPosition).equals(list.get(newItemPosition));
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return mList.get(oldItemPosition).getmText().equals(list.get(newItemPosition).getmText());
                }
            });
            mList.clear();
            mList.addAll(list);
            result.dispatchUpdatesTo(this);
        }
    }
}
