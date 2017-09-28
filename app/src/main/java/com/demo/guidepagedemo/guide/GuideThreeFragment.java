package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.customview.CustomImageView;
import com.demo.guidepagedemo.R;

import butterknife.BindView;

/**
 * Created by SuperD on 2017/9/5.
 */

public class GuideThreeFragment extends BaseFragment {

    @BindView(R.id.guide_three_title)
    CustomImageView mTitleIv;
    @BindView(R.id.guide_three_cloud)
    CustomImageView mCloudIv;
    @BindView(R.id.guide_three_clothes)
    CustomImageView mClothesIv;
    @BindView(R.id.guide_three_airball)
    CustomImageView mAirballIv;
    @BindView(R.id.guide_three_effigy)
    CustomImageView mEffigyIv;
    @BindView(R.id.guide_three_road)
    CustomImageView mRoadIv;
    @BindView(R.id.guide_three_house)
    CustomImageView mHouseIv;
    @BindView(R.id.guide_three_bridge)
    CustomImageView mBridgeIv;

    public static GuideThreeFragment newInstance() {
        Bundle args = new Bundle();
        GuideThreeFragment fragment = new GuideThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_three;
    }

    @Override
    protected void initView() {
        views.add(mTitleIv);
        views.add(mCloudIv);
        views.add(mClothesIv);
        views.add(mAirballIv);
        views.add(mEffigyIv);
        views.add(mRoadIv);
        views.add(mHouseIv);
        views.add(mBridgeIv);
    }

}
