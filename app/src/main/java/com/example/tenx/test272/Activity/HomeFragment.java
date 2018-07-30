package com.example.tenx.test272.Activity;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tenx.test272.Activity.Adapters.HomePagerAdapter;
import com.example.tenx.test272.R;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment{

    ViewPager viewPager;
    HomePagerAdapter homePagerAdapter;
    TabLayout tabLayout;
    Timer timer;

    int current_page = 0;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3500;
    final long NUM_PAGES = 4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.home_view_pager);
        homePagerAdapter = new HomePagerAdapter(getActivity());
        viewPager.setAdapter(homePagerAdapter);




        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if(current_page == NUM_PAGES){
                    current_page = 0;
                }
                viewPager.setCurrentItem(current_page++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
        return view;
    }
}
