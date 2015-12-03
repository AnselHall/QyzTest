package com.qyz.qyztest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.qyz.qyztest.view.ArcView;

public class MainActivity extends AppCompatActivity {


    private LinearLayout rootLi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        rootLi = (LinearLayout) findViewById(R.id.root_ll);
        ArcView arcView = new ArcView(this);
        arcView.setarc(13,20);
        rootLi.addView(arcView);
    }
}
