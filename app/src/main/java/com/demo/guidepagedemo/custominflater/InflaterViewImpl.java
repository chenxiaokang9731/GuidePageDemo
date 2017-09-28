package com.demo.guidepagedemo.custominflater;

import android.view.View;

import java.util.List;

/**
 * Created by SuperD on 2017/9/6.
 */

public interface InflaterViewImpl {

    /**
     * 获取View集合
     *
     * @return
     */
    List<View> getViews();


    /**
     * 添加元素
     */
    void addView(View view);
}
