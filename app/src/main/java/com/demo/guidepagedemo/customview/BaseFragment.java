package com.demo.guidepagedemo.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by SuperD on 2017/9/4.
 */

public abstract class BaseFragment extends Fragment {

    protected List<CustomImageView> views = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    public List<CustomImageView> getViews() {
        return views;
    }

    public abstract int setLayoutId();


    protected abstract void initView();
}
