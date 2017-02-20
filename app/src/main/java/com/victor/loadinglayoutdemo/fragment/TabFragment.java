package com.victor.loadinglayoutdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.victor.loadinglayout.LoadingLayout;
import com.victor.loadinglayoutdemo.R;

public class TabFragment extends Fragment implements View.OnClickListener {

    public static final String TAB_POSITION = "tab_position";
    private int tabPosition;

    LoadingLayout loadingLayout;

    public TabFragment() {
        // Required empty public constructor
    }

    public static TabFragment newInstance(int tabPosition) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tabPosition = getArguments().getInt(TAB_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab, container, false);
        loadingLayout = (LoadingLayout) view.findViewById(R.id.loading_layout);
        Button mBtnEmpty = (Button) view.findViewById(R.id.btn_empty_view);
        Button mBtnError = (Button) view.findViewById(R.id.btn_error_view);
        Button mBtnLoading = (Button) view.findViewById(R.id.btn_loading_view);
        Button mBtnContent = (Button) view.findViewById(R.id.btn_content_view);

        mBtnEmpty.setOnClickListener(this);
        mBtnError.setOnClickListener(this);
        mBtnLoading.setOnClickListener(this);
        mBtnContent.setOnClickListener(this);

        loadingLayout
                .setErrorView(R.layout.error_view_demo)
                .setEmptyText(String.format(getString(R.string.tab_n_no_data), tabPosition))
                .setErrorText(String.format(getString(R.string.tab_n_error), tabPosition))
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
                .showEmpty();

        return view;
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
}
