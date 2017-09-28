package com.demo.guidepagedemo.guide;

import android.os.Bundle;

import com.demo.guidepagedemo.customview.BaseFragment;
import com.demo.guidepagedemo.customview.CustomImageView;
import com.demo.guidepagedemo.R;

import butterknife.BindView;

/**
 * Created by SuperD on 2017/9/5.
 */

public class GuideFiveFragment extends BaseFragment {


    @BindView(R.id.guide_five_title)
    CustomImageView mTitleIv;
    @BindView(R.id.guide_five_camera)
    CustomImageView mCameraIv;
    @BindView(R.id.guide_five_perfume)
    CustomImageView mPerfumeIv;
    @BindView(R.id.guide_five_drinks)
    CustomImageView mDrinksIv;
    @BindView(R.id.guide_five_sktwo)
    CustomImageView mSktwoIv;
    @BindView(R.id.guide_five_blue_ball)
    CustomImageView mBlueBallIv;
    @BindView(R.id.guide_five_pink_ball)
    CustomImageView mPinkBallIv;
    @BindView(R.id.guide_five_bracelet)
    CustomImageView mBraceletIv;
    @BindView(R.id.guide_five_orange_ball)
    CustomImageView mOrangeBallIv;
    @BindView(R.id.guide_five_hang_ball)
    CustomImageView mHangBallIv;
    @BindView(R.id.guide_five_edt)
    CustomImageView mEdtIv;
    @BindView(R.id.guide_five_brownness_ball)
    CustomImageView mBrownnessBallIv;
    @BindView(R.id.guide_five_cat)
    CustomImageView mCatIv;

    public static GuideFiveFragment newInstance() {
        Bundle args = new Bundle();
        GuideFiveFragment fragment = new GuideFiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_guide_five;
    }

    @Override
    protected void initView() {
        views.add(mTitleIv);
        views.add(mCameraIv);
        views.add(mPerfumeIv);
        views.add(mDrinksIv);
        views.add(mSktwoIv);
        views.add(mBlueBallIv);
        views.add(mPinkBallIv);
        views.add(mBraceletIv);
        views.add(mOrangeBallIv);
        views.add(mHangBallIv);
        views.add(mEdtIv);
        views.add(mBrownnessBallIv);
        views.add(mCatIv);
    }

}
