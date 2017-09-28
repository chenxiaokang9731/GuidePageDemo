package com.demo.guidepagedemo.custominflater;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.demo.guidepagedemo.R;

/**
 * Created by SuperD on 2017/9/27.
 */

public class CustomFactory implements LayoutInflater.Factory {

    private LayoutInflater mInflater;

    private InflaterViewImpl mInflaterView;


    private final String[] sClassPrefix = {
            "android.widget.",
            "android.view."
    };

    public CustomFactory(LayoutInflater mInflater, InflaterViewImpl mInflaterView) {
        this.mInflater = mInflater;
        this.mInflaterView = mInflaterView;
    }


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        try {
            if (name.contains(".")) {
                String checkName = name.substring(name.lastIndexOf("."));
                String prefix = name.substring(0, name.lastIndexOf("."));
                view = createViewFail(checkName, prefix, attrs);
            }
            //2.如果是系统视图则需要加上系统的前缀
            if (name.equals("View") || name.equals("ViewGroup")) {
                view = createViewFail(name, sClassPrefix[1], attrs);
            } else {
                view = createViewFail(name, sClassPrefix[0], attrs);
            }
            //实例化完成
            if (view != null) {
                //获取自定义属性,通过标签关联到视图上
                setViewTag(view, context, attrs);
                mInflaterView.addView(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void setViewTag(View view, Context context, AttributeSet attrs) {
        //解析自定义的属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        if (attrs != null && array.length() > 0) {
            AttrTagBean bean = new AttrTagBean();
            bean.xIn = array.getFloat(R.styleable.CustomImageView_in_value_x, 0f);
            bean.xOut = array.getFloat(R.styleable.CustomImageView_out_value_x, 0f);
            bean.yIn = array.getFloat(R.styleable.CustomImageView_in_value_y, 0f);
            bean.yOut = array.getFloat(R.styleable.CustomImageView_out_value_y, 0f);
            //index
            view.setTag(bean);
        }
        array.recycle();
    }


    /**
     * 创建View失败的话，就调用mInflater的默认生成方式
     *
     * @param name
     * @param prefix
     * @param attrs
     * @return
     */
    private View createViewFail(String name, String prefix, AttributeSet attrs) {
        View view = null;
        try {
            view = mInflater.createView(name, prefix, attrs);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return view;
    }
}
