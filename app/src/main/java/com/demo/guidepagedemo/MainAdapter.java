package com.demo.guidepagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by SuperD on 2017/9/2.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MainAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments != null && mFragments.size() > 0 ? mFragments.get(position) : null;
    }

    @Override
    public int getCount() {
        return mFragments != null && mFragments.size() > 0 ? mFragments.size() : 0;
    }
}
