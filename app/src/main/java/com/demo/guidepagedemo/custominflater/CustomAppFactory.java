package com.demo.guidepagedemo.custominflater;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.demo.guidepagedemo.R;

/**
 * Created by SuperD on 2017/9/6.
 */

public class CustomAppFactory implements LayoutInflater.Factory2 {

    private LayoutInflater mInflater;

    private InflaterViewImpl mInflaterView;

    private final String[] sClassPrefix = {
            "android.widget.",
            "android.view."
    };

    public CustomAppFactory(LayoutInflater mInflater, InflaterViewImpl mInflaterView) {
        this.mInflater = mInflater;
        this.mInflaterView = mInflaterView;
    }


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        Log.d("名称检查", name + "");
        try {
            if (name.contains(".")) {
                String checkName = name.substring(name.lastIndexOf("."));
                String prefix = name.substring(0, name.lastIndexOf("."));
                view = defaultInflater(checkName, prefix, attrs);
            }
            if (name.equals("View") || name.equals("ViewGroup")) {
                view = defaultInflater(name, sClassPrefix[1], attrs);
            } else {
                view = defaultInflater(name, sClassPrefix[0], attrs);
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

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = onCreateView(name, context, attrs);
        return view;
    }


    private View defaultInflater(String name, String prefix, AttributeSet attrs) {
        View view = null;
        try {
            view = mInflater.createView(name, prefix, attrs);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return view;
    }

    /**
     * 将View的属性信息存储在Tag中
     */
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
}
