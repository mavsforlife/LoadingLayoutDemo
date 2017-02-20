package com.victor.loadinglayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by victor on 2017/2/17.
 */

public class LoadingLayout extends FrameLayout {

    private View mEmptyView, mErrorView, mLoadingView;
    private OnClickListener onErrorClickListener;
    private OnClickListener onEmptyClickListener;
    private LayoutInflater mLayoutInflater;

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LoadingLayout, 0, 0);

        try {
            int emptyView = a.getResourceId(R.styleable.LoadingLayout_emptyView, R.layout.empty_view);
            int errorView = a.getResourceId(R.styleable.LoadingLayout_errorView, R.layout.error_view);
            int loadingView = a.getResourceId(R.styleable.LoadingLayout_loadingView, R.layout.loading_view);

            mLayoutInflater = LayoutInflater.from(getContext());
            mEmptyView = mLayoutInflater.inflate(emptyView, this, true);
            mErrorView = mLayoutInflater.inflate(errorView, this, true);
            mLoadingView = mLayoutInflater.inflate(loadingView, this, true);
        }finally {
            a.recycle();
        }

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        for (int i = 0; i < getChildCount() - 1; i++) {
            getChildAt(i).setVisibility(GONE);
        }

        findViewById(R.id.btn_empty).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onEmptyClickListener) {
                    onEmptyClickListener.onClick(v);
                }
            }
        });

        findViewById(R.id.btn_error).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onErrorClickListener) {
                    onErrorClickListener.onClick(v);
                }
            }
        });
    }

    public void showEmpty() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 0) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public void showError() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 1) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public void showLoading() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 2) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public void showContent() {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (i == 3) {
                child.setVisibility(VISIBLE);
            } else {
                child.setVisibility(GONE);
            }
        }
    }

    public LoadingLayout setOnEmptyClickListener(OnClickListener onEmptyClickListener) {
        this.onEmptyClickListener = onEmptyClickListener;
        return this;
    }

    public LoadingLayout setOnErrorClickListener(OnClickListener onErrorClickListener) {
        this.onErrorClickListener = onErrorClickListener;
        return this;
    }

    public LoadingLayout setEmptyView(@LayoutRes int layout) {
        removeView(getChildAt(0));
        mEmptyView = mLayoutInflater.inflate(layout, null, true);
        addView(mEmptyView, 0);
        onFinishInflate();
        return this;
    }

    public LoadingLayout setErrorView(@LayoutRes int layout) {
        removeView(getChildAt(1));
        mErrorView = mLayoutInflater.inflate(layout, null, true);
        addView(mErrorView, 1);
        onFinishInflate();
        return this;
    }

    public LoadingLayout setLoadingView(@LayoutRes int layout) {
        removeView(getChildAt(2));
        mLoadingView = mLayoutInflater.inflate(layout, null, true);
        addView(mLoadingView, 2);
        return this;
    }

    public LoadingLayout setEmptyText(String text) {
        ((TextView) findViewById(R.id.btn_empty)).setText(text);
        return this;
    }

    public LoadingLayout setErrorText(String text) {
        ((TextView) findViewById(R.id.tv_error)).setText(text);
        return this;
    }
}
