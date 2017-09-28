package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.customview.CustomImageView;
import com.demo.guidepagedemo.R;

import butterknife.BindView;

/**
 * Created by SuperD on 2017/9/5.
 */

public class GuideFourFragment extends BaseFragment {


    @BindView(R.id.guide_four_title)
    CustomImageView mTitleIv;
    @BindView(R.id.guide_four_cloud)
    CustomImageView mCloudIv;
    @BindView(R.id.guide_four_ball)
    CustomImageView mBallIv;
    @BindView(R.id.guide_four_right_cloud)
    CustomImageView mRightCloudIv;
    @BindView(R.id.guide_four_house)
    CustomImageView mHouseIv;
    @BindView(R.id.guide_four_torn)
    CustomImageView mTornIv;
    @BindView(R.id.guide_four_building)
    CustomImageView mBuildingIv;
    @BindView(R.id.guide_four_road)
    CustomImageView mRoadIv;

    public static GuideFourFragment newInstance() {
        Bundle args = new Bundle();
        GuideFourFragment fragment = new GuideFourFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_four;
    }

    @Override
    protected void initView() {
        views.add(mTitleIv);
        views.add(mCloudIv);
        views.add(mBallIv);
        views.add(mRightCloudIv);
        views.add(mHouseIv);
        views.add(mTornIv);
        views.add(mBuildingIv);
        views.add(mRoadIv);
    }
}
