package com.example.xlz.qiangdan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xlz.qiangdan.R;

/**
 * Created by xlz on 2016/5/27.
 */
public class PersonalDataFragment extends BaseFragment {

    private View view;
    
    private TextView tv_title;

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initView();

        return view;
    }

    private void initView() {
        view = View.inflate(activity, R.layout.fragment_personal_data, null);

    }

}
