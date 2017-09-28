package com.demo.guidepagedemo.custominflater;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuperD on 2017/9/6.
 */

public class PageFragment extends Fragment implements InflaterViewImpl {

    public static final String LAYOUT_ID = "layout_id";


    private List<View> views = new ArrayList<>();

    public static PageFragment newInstance(int resId) {
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, resId);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        int layoutId = bundle.getInt(LAYOUT_ID);


        //1.通过自己自定义的布局解析器,其实也就是自定义LayoutInflater的Factory
        //2.新设置的LayoutInflater和factory是相互绑定的,不要和旧的弄混了.
        LayoutInflater newInflater = inflater.cloneInContext(getActivity());
       //CustomLayoutInflater newInflater = new CustomLayoutInflater(getActivity());
        newInflater.setFactory2(new CustomAppFactory(newInflater, this));
        return newInflater.inflate(layoutId, null);
    }

    @Override
    public List<View> getViews() {
        return views;
    }

    @Override
    public void addView(View view) {
        if (views.contains(view)) {
            return;
        }
        views.add(view);
    }
}
