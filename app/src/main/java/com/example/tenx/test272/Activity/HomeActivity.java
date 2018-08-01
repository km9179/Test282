package com.example.tenx.test272.Activity;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tenx.test272.Activity.Adapters.FragmentAdapter;
import com.example.tenx.test272.R;

import java.util.Objects;


public class HomeActivity extends AppCompatActivity {


    TabLayout tabLayout;
    FragmentAdapter fragAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //setting up the tablayout and viewPager
        fragAdapter = new FragmentAdapter(getSupportFragmentManager());
        tabLayout = findViewById(R.id.home_tablayout);
        viewPager = findViewById(R.id.contaier_view_pager);
        viewPager.setAdapter(fragAdapter);

        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.tablayout_icon_home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.tablayout_icon_whatshot);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.tablayout_icon_notifications);

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_highlight), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.tab_normal), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setSelectedTabIndicatorHeight(0);
    }

    @Override
    public void onBackPressed() {
        int cur = viewPager.getCurrentItem();
        if(cur >0){
            viewPager.setCurrentItem(cur-1);
        }


    }
}
