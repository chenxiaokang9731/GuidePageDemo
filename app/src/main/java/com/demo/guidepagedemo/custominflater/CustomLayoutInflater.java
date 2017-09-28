package com.demo.guidepagedemo.custominflater;

import android.content.Context;
import android.view.LayoutInflater;

/**
 * Created by SuperD on 2017/9/27.
 */

public class CustomLayoutInflater extends LayoutInflater {

    protected CustomLayoutInflater(Context context) {
        super(context);
    }

    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return new CustomLayoutInflater(newContext);
    }
}
