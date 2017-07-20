package com.victor.loadinglayoutdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.victor.loadinglayoutdemo.R;
import com.victor.loadinglayoutdemo.adapter.PagerAdapter;
import com.victor.loadinglayoutdemo.fragment.TabFragment;

public class TabActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mPager;
    String[] mTitles;
    Fragment[] mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        init();
    }

    private void init() {
        setTitle(R.string.tab_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.view_pager);

        mTitles = getResources().getStringArray(R.array.titles);
        mFragments = new Fragment[mTitles.length];
        mFragments[0] = TabFragment.newInstance(1);
        mFragments[1] = TabFragment.newInstance(2);
        mFragments[2] = TabFragment.newInstance(3);
        mFragments[3] = TabFragment.newInstance(4);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(mFragments.length - 1);
        mTabLayout.setupWithViewPager(mPager);
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
        context.startActivity(new Intent(context, TabActivity.class));
    }
}
