package com.demo.guidepagedemo.customview;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.demo.guidepagedemo.MainAdapter;
import com.demo.guidepagedemo.R;
import com.demo.guidepagedemo.guide.GuideFiveFragment;
import com.demo.guidepagedemo.guide.GuideFourFragment;
import com.demo.guidepagedemo.guide.GuideLoginFragment;
import com.demo.guidepagedemo.guide.GuideOneFragment;
import com.demo.guidepagedemo.guide.GuideThreeFragment;
import com.demo.guidepagedemo.guide.GuideTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomViewActivity extends AppCompatActivity {

    private ViewPager mMainVp;
    private ImageView mMainIv;

    private MainAdapter mAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    /**
     * 初始化View
     */
    private void initView() {
        mMainVp = (ViewPager) findViewById(R.id.main_vp);
        mMainIv = (ImageView) findViewById(R.id.main_iv);
    }

    /**
     * 加载数据
     */
    private void initData() {
        fragments.add(new GuideOneFragment().newInstance());
        fragments.add(new GuideTwoFragment().newInstance());
        fragments.add(new GuideThreeFragment().newInstance());
        fragments.add(new GuideFourFragment().newInstance());
        fragments.add(new GuideFiveFragment().newInstance());
        fragments.add(new GuideLoginFragment().newInstance());
        mAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        mMainVp.setAdapter(mAdapter);
    }

    /**
     * 加载监听
     */
    private void initListener() {
        /**
         * 这里只对已经 展示的界面添加效果,还未进入的界面无任何效果
         */


        mMainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int vpWidth = mMainVp.getWidth();
                //获取到正在进入的页面
                BaseFragment inFragment = getPosition(position - 1);
                if (inFragment != null) {
                    List<CustomImageView> views = inFragment.getViews();
                    if (views != null && views.size() > 0) {
                        for (CustomImageView view : inFragment.views) {
                            view.setTranslationX((vpWidth - positionOffsetPixels) * view.inValueX);
                            view.setTranslationY((vpWidth - positionOffsetPixels) * view.inValueY);
                        }
                    }
                }

                //获取退出的页面
                BaseFragment outFragment = getPosition(position);
                if (outFragment != null) {
                    List<CustomImageView> views = outFragment.getViews();
                    if (views != null && views.size() > 0) {
                        for (CustomImageView view : outFragment.views) {
                            view.setTranslationX((0 - positionOffsetPixels) * view.outValueX);
                            view.setTranslationY((0 - positionOffsetPixels) * view.outValueY);
                        }
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position == fragments.size() - 1) {
                    mMainIv.setVisibility(View.GONE);
                } else {
                    mMainIv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Drawable anim = mMainIv.getBackground();
                if (!(anim instanceof AnimationDrawable)) {
                    return;
                }
                AnimationDrawable animation = (AnimationDrawable) anim;
                Log.d("滑动状态", state + "");
                switch (state) {
                    //空闲状态
                    case ViewPager.SCROLL_STATE_IDLE:
                        animation.stop();
                        break;
                    //拖动状态
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        animation.start();
                        break;
                    //惯性滑动状态
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;
                }
            }
        });
    }


    /**
     * 获取该位置的Fragment
     *
     * @return
     */
    private BaseFragment getPosition(int position) {
        BaseFragment fragment = null;
        if (position >= 0 && position < fragments.size()) {
            fragment = (BaseFragment) fragments.get(position);
        }
        return fragment;
    }

}
