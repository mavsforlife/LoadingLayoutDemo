package com.victor.loadinglayoutdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.victor.loadinglayoutdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        Button mBtnSimple = (Button) findViewById(R.id.btn_simple_activity);
        Button mBtnTab = (Button) findViewById(R.id.btn_tab_activity);
        Button mBtnSet = (Button) findViewById(R.id.btn_set_activity);

        mBtnSimple.setOnClickListener(this);
        mBtnTab.setOnClickListener(this);
        mBtnSet.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_simple_activity:
                SimpleActivity.enter(this);
                break;

            case R.id.btn_tab_activity:
                TabActivity.enter(this);
                break;

            case R.id.btn_set_activity:
                SetLoadingActivity.enter(this);
            default:
                break;
        }
    }
}
