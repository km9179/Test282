package com.example.tenx.test272.Activity.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tenx.test272.R;

import Utils.EventsUtils;

public class CustomAdapter extends PagerAdapter{
    private Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        String currentEvent = EventsUtils.upcomingEvents[position];
        String currentBackground = EventsUtils.backgroundColors[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.slide, container, false);
        TextView eventText = view.findViewById(R.id.slide_text);
        eventText.setText(currentEvent);
        eventText.setBackgroundColor(Color.parseColor(currentBackground));
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return EventsUtils.upcomingEvents.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
