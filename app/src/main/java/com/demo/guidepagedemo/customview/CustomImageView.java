package com.demo.guidepagedemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.demo.guidepagedemo.R;

/**
 * Created by SuperD on 2017/9/4.
 */

public class CustomImageView extends ImageView {

    /**
     * 进入的阻尼系数
     */
    public float inValueX;
    public float outValueX;

    public float inValueY;
    public float outValueY;


    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView);
        inValueX = array.getFloat(R.styleable.CustomImageView_in_value_x, 0f);
        inValueY = array.getFloat(R.styleable.CustomImageView_in_value_y, 0f);
        outValueX = array.getFloat(R.styleable.CustomImageView_out_value_x, 0f);
        outValueY = array.getFloat(R.styleable.CustomImageView_out_value_y, 0f);
        array.recycle();
        init();
    }

    private void init() {


    }

    public float getInValueX() {
        return inValueX;
    }

    public void setInValueX(float inValueX) {
        this.inValueX = inValueX;
    }

    public float getOutValueX() {
        return outValueX;
    }

    public void setOutValueX(float outValueX) {
        this.outValueX = outValueX;
    }

    public float getInValueY() {
        return inValueY;
    }

    public void setInValueY(float inValueY) {
        this.inValueY = inValueY;
    }

    public float getOutValueY() {
        return outValueY;
    }

    public void setOutValueY(float outValueY) {
        this.outValueY = outValueY;
    }
}
