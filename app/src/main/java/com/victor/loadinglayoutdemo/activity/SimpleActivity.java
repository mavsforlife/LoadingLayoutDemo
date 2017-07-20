package com.victor.loadinglayoutdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.victor.loadinglayout.LoadingLayout;
import com.victor.loadinglayoutdemo.R;

public class SimpleActivity extends AppCompatActivity implements View.OnClickListener{

    LoadingLayout loadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        initView();
    }

    private void initView() {
        setTitle(R.string.simple_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);
        Button mBtnEmpty = (Button) findViewById(R.id.btn_empty_view);
        Button mBtnError = (Button) findViewById(R.id.btn_error_view);
        Button mBtnLoading = (Button) findViewById(R.id.btn_loading_view);
        Button mBtnContent = (Button) findViewById(R.id.btn_content_view);

        mBtnEmpty.setOnClickListener(this);
        mBtnError.setOnClickListener(this);
        mBtnLoading.setOnClickListener(this);
        mBtnContent.setOnClickListener(this);

        loadingLayout
                .setOnEmptyClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadingLayout.showLoading();
                    }
                })
                .setOnErrorClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadingLayout.showLoading();
                    }
                })
                .showContent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_empty_view:
                loadingLayout.showEmpty();
                break;

            case R.id.btn_error_view:
                loadingLayout.showError();
                break;

            case R.id.btn_loading_view:
                loadingLayout.showLoading();
                break;

            case R.id.btn_content_view:
                loadingLayout.showContent();
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void enter(Context context) {
        context.startActivity(new Intent(context, SimpleActivity.class));
    }
}
