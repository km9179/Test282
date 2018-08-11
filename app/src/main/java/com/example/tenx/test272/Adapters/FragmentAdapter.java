package com.example.tenx.test272.Adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tenx.test272.Activity.FragmentMenu;
import com.example.tenx.test272.Activity.FragmentNotifications;
import com.example.tenx.test272.Activity.FragmentWhatsHot;
import com.example.tenx.test272.Activity.FragmentHome;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<android.support.v4.app.Fragment> fragList = new ArrayList<>();


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragList.add(new FragmentHome());
        fragList.add(new FragmentWhatsHot());
        fragList.add(new FragmentNotifications());
        fragList.add(new FragmentMenu());
    }

    @Override
    public android.support.v4.app.Fragment getItem(int i) {
        return fragList.get(i);
    }



    @Override
    public int getCount() {
        return fragList.size();
    }


}
