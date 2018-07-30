package com.example.tenx.test272.Activity.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tenx.test272.R;

import java.util.Calendar;

import Utils.EventsUtils;

public class WhatsHotAdapter extends RecyclerView.Adapter<WhatsHotAdapter.CustomViewHolder>{


    private Context context;

    public WhatsHotAdapter(Context context ) {
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

                //building the dialog
                builder.setView(mainView);
                builder.setCancelable(true);
                final AlertDialog dialog = builder.create();

                ImageView img = mainView.findViewById(R.id.dialog_event_image);
                TextView tv = mainView.findViewById(R.id.dialog_event_des);
                Glide.with(context).load(imageUrl).apply(new RequestOptions().centerCrop()).into(img);
                tv.setText(context.getResources().getString(R.string.test_desc));
                dialog.show();

                //implement the share button
                ImageView share = mainView.findViewById(R.id.dialog_icon_share);
                share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        String shareBody = "http://tecnoesis.in/";
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tecnoesis");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        context.startActivity(Intent.createChooser(shareIntent, "share via"));
                    }
                });
                    //implement web_icon clicks and reminder taps
                ImageView web = mainView.findViewById(R.id.dialog_icon_web);
                ImageView closeBtn = mainView.findViewById(R.id.dialog_icon_close);
                web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String eventUrl = "http://tecnoesis.in";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(eventUrl));
                        context.startActivity(i);
                    }
                });


                //reminder button
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            dialog.dismiss();
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



