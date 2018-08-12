package com.example.tenx.test272.Adapters.Listeners;

import android.support.v4.view.ViewPager;

import com.example.tenx.test272.Adapters.HomePagerAdapter;

public class CircularPagerHandler implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private HomePagerAdapter mAdapter;
    private int currentPosition;
    private int mScrollState;
    int size;

    public CircularPagerHandler(ViewPager mViewPager, HomePagerAdapter mAdapter) {
        this.mViewPager = mViewPager;
        this.mAdapter = mAdapter;
        size = mAdapter.getCount();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        handleScrollState(state);
        mScrollState = state;
    }

    private void handleScrollState(final int state) {
        if(state == ViewPager.SCROLL_STATE_DRAGGING && currentPosition==0 || currentPosition == size-1){
            swapFirstAndlast();
        }
    }

    private void swapFirstAndlast() {
        final int lastPosition = size - 1;
        if(currentPosition == 0) {
            mViewPager.setCurrentItem(lastPosition-1, false);
        } else if(currentPosition == lastPosition) {
            mViewPager.setCurrentItem(1, false);
        }
    }
}
