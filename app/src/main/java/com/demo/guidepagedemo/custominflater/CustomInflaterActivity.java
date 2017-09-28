package com.demo.guidepagedemo.custominflater;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.demo.guidepagedemo.MainAdapter;
import com.demo.guidepagedemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomInflaterActivity extends AppCompatActivity {

    @BindView(R.id.inflater_vp)
    ViewPager mInflaterVp;
    @BindView(R.id.inflater_iv)
    ImageView mInflaterIv;

    private MainAdapter mAdapter;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_inflater);

        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initData() {
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_one));
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_two));
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_three));
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_four));
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_five));
        fragments.add(PageFragment.newInstance(R.layout.fragment_guide_login));
        mAdapter = new MainAdapter(getSupportFragmentManager(), fragments);
        mInflaterVp.setAdapter(mAdapter);
    }

    private void initListener() {
        mInflaterVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //获取ViewPager的宽度
                int vpWidth = mInflaterVp.getWidth();
                //获取正在进入的界面
                PageFragment inFragment = getPosition(position - 1);
                if (inFragment != null) {
                    List<View> views = inFragment.getViews();
                    if (views != null && views.size() > 0) {
                        for (View view : views) {
                            AttrTagBean tag = (AttrTagBean) view.getTag();
                            if (tag != null) {
                                view.setTranslationX((vpWidth - positionOffsetPixels) * tag.xIn);
                                view.setTranslationY((vpWidth - positionOffsetPixels) * tag.yIn);
                            }
                        }
                    }
                }

                //当前正在滑动的界面
                PageFragment outFragment = getPosition(position);
                if (outFragment != null) {
                    List<View> views = outFragment.getViews();
                    if (views != null && views.size() > 0) {
                        for (View view : views) {
                            AttrTagBean tag = (AttrTagBean) view.getTag();
                            if (tag != null) {
                                view.setTranslationX((0 - positionOffsetPixels) * tag.xOut);
                                view.setTranslationY((0 - positionOffsetPixels) * tag.yOut);
                            }
                        }
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (position == fragments.size() - 1) {
                    mInflaterIv.setVisibility(View.GONE);
                } else {
                    mInflaterIv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Drawable anim = mInflaterIv.getBackground();
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
    private PageFragment getPosition(int position) {
        PageFragment fragment = null;
        if (position >= 0 && position < fragments.size()) {
            fragment = (PageFragment) fragments.get(position);
        }
        return fragment;
    }
}
