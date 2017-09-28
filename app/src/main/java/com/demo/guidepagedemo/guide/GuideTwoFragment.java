package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.customview.CustomImageView;
import com.demo.guidepagedemo.R;

import butterknife.BindView;

/**
 * Created by SuperD on 2017/9/4.
 */

public class GuideTwoFragment extends BaseFragment {

    @BindView(R.id.guide_two_font)
    CustomImageView mFontIv;
    @BindView(R.id.guide_two_tower)
    CustomImageView mTowerIv;
    @BindView(R.id.guide_two_right_cloud)
    CustomImageView mRightCloudIv;
    @BindView(R.id.guide_two_left_cloud)
    CustomImageView mLeftCloudIv;
    @BindView(R.id.guide_two_water)
    CustomImageView mWaterIv;
    @BindView(R.id.guide_two_mountain)
    CustomImageView mMountainIv;
    @BindView(R.id.guide_two_torn)
    CustomImageView mTornIv;
    @BindView(R.id.guide_two_bottom_cloud)
    CustomImageView mBottomCloudIv;

    public static GuideTwoFragment newInstance() {
        Bundle args = new Bundle();
        GuideTwoFragment fragment = new GuideTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_two;
    }

    @Override
    protected void initView() {
        views.add(mFontIv);
        views.add(mTowerIv);
        views.add(mRightCloudIv);
        views.add(mLeftCloudIv);
        views.add(mWaterIv);
        views.add(mMountainIv);
        views.add(mTornIv);
        views.add(mBottomCloudIv);
    }


}
