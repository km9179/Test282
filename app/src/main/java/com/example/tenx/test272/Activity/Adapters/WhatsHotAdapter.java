package com.example.tenx.test272.Activity.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        final String imageUrl = EventsUtils.mainEventsImageUrl[position];
        Glide.with(context).load(imageUrl).apply(new RequestOptions().centerCrop()).into(holder.eventImage);
        holder.layout_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                //main view
                final View mainView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);

                builder.setView(mainView);
                AlertDialog dialog = builder.create();
                ImageView img = mainView.findViewById(R.id.dialog_event_image);
                TextView tv = mainView.findViewById(R.id.dialog_event_des);
                Glide.with(context).load(imageUrl).apply(new RequestOptions().centerCrop()).into(img);
                tv.setText("This is a test description.This is a test description.This is a test description.This is a test description.This is a test description.");
                dialog.show();

                //implement the share button
                ImageView share = mainView.findViewById(R.id.dialog_icon_share);
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        String shareBody = "Link to website here";
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tecnoesis");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        context.startActivity(Intent.createChooser(shareIntent, "share via"));
                    }
                });
                    //implement web_icon clicks and reminder taps
                ImageView web = mainView.findViewById(R.id.dialog_icon_web);
                ImageView rem = mainView.findViewById(R.id.dialog_icon_remind);
                web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "This will take you to Tecnoesis website.....Soon....!", Toast.LENGTH_SHORT).show();
                    }
                });
                rem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "This will set a reminder for you.....Soon....!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


    }

    @Override
    public int getItemCount() {
        return EventsUtils.mainEventsImageUrl.length;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView eventImage;
        private RelativeLayout layout_holder;

        private CustomViewHolder(View itemView) {
            super(itemView);
            eventImage = itemView.findViewById(R.id.event_image);
            layout_holder = itemView.findViewById(R.id.container_whatshot);
        }
    }
}
