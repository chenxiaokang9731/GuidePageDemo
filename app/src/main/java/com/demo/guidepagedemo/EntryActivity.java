package com.demo.guidepagedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.demo.guidepagedemo.custominflater.CustomInflaterActivity;
import com.demo.guidepagedemo.customview.CustomViewActivity;

import butterknife.ButterKnife;

public class EntryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        ButterKnife.bind(this);
    }

    /**
     * 自定义View方式实现
     *
     * @param view
     */
    public void customView(View view) {
        Intent intent = new Intent(this, CustomViewActivity.class);
        startActivity(intent);
    }

    /**
     * 自定义Inflater方式实现
     *
     * @param view
     */
    public void customInflater(View view) {
        Intent intent = new Intent(this, CustomInflaterActivity.class);
        startActivity(intent);
    }

}

