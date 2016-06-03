package com.example.xlz.qiangdan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.xlz.qiangdan.R;
import com.example.xlz.qiangdan.activity.ContentActivity;
import com.example.xlz.qiangdan.adapter.StatusAdapter;
import com.example.xlz.qiangdan.entity.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlz on 2016/5/25.
 */
public class HomeFragment extends BaseFragment {

    private View view;

    private ListView lv_home;

    private StatusAdapter adapter;

    private List<Status> statuses = new ArrayList<Status>();

    private FragmentController controller;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initView();
        loadData();

        return view;
    }

    private void initView() {
        view = View.inflate(activity, R.layout.fragment_home, null);

        controller = FragmentController.getInstance(activity, R.id.content);

        lv_home = (ListView) view.findViewById(R.id.lv_home);
        adapter = new StatusAdapter(activity, R.layout.item_status, statuses);
        lv_home.setAdapter(adapter);
        lv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Status status = statuses.get(position);
                Intent intent = new Intent(getActivity(), ContentActivity.class);
                intent.putExtra("content", status.getContent());
                intent.putExtra("price", status.getPrice());
                getActivity().startActivity(intent);
            }
        });
    }

    private void loadData() {
        Status status1 = new Status("[宝安店]正新鸡排尊享套餐，建议单人使用", "价格：1元",
                "17小时前", "仅剩8个名额", "6天到期");
        statuses.add(status1);
        Status status2 = new Status("微信摇一摇，九宫格", "招标：可议价",
                "2016-5-15", "仅剩1个名额", "4天到期");
        statuses.add(status2);
    }

}
