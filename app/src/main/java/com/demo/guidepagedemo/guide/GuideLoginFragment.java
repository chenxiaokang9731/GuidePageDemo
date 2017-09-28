package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.R;

/**
 * Created by SuperD on 2017/9/5.
 */

public class GuideLoginFragment extends BaseFragment {

    public static GuideLoginFragment newInstance() {
        Bundle args = new Bundle();
        GuideLoginFragment fragment = new GuideLoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_login;
    }

    @Override
    protected void initView() {

    }
}
