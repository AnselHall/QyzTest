package com.qyz.qyztest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.qyz.qyztest.view.ArcView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout rootLi;
    private ArcView arcView;
    private int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rootLi = (LinearLayout) findViewById(R.id.root_ll);
        arcView = new ArcView(this);

        //设置分子
        arcView.setNumerator(18);

        //设置分母
        arcView.setDenominator(31);
        rootLi.addView(arcView);
    }
}
