package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.customview.CustomImageView;
import com.demo.guidepagedemo.R;

import butterknife.BindView;

/**
 * Created by SuperD on 2017/9/4.
 * 引导页第一页
 */

public class GuideOneFragment extends BaseFragment {

    @BindView(R.id.guide_one_font)
    CustomImageView mFontIv;
    @BindView(R.id.guide_one_cloud)
    CustomImageView mCloudIv;
    @BindView(R.id.guide_one_package)
    CustomImageView mPackageIv;
    @BindView(R.id.guide_one_ballute)
    CustomImageView mBalluteIv;
    @BindView(R.id.guide_one_background)
    CustomImageView mBackgroundIv;
    @BindView(R.id.guide_one_road)
    CustomImageView mRoadIv;
    @BindView(R.id.guide_one_house)
    CustomImageView mHouseIv;
    @BindView(R.id.guide_one_duck)
    CustomImageView mDuckIv;

    public static GuideOneFragment newInstance() {
        Bundle args = new Bundle();
        GuideOneFragment fragment = new GuideOneFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_one;
    }

    @Override
    protected void initView() {
        views.add(mFontIv);
        views.add(mCloudIv);
        views.add(mPackageIv);
        views.add(mBalluteIv);
        views.add(mBackgroundIv);
        views.add(mRoadIv);
        views.add(mHouseIv);
        views.add(mDuckIv);
    }

}
