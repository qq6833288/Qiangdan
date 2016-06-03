package com.example.xlz.qiangdan.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;

/**
 * 页面Fragment的切换用同一个控制器就行了，所以设置为单例模式
 */
public class FragmentController {

    private int containerId;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments;

    private static FragmentController controller;

    public static FragmentController getInstance(FragmentActivity activity, int containerId) {
        if (controller == null) {
            controller = new FragmentController(activity, containerId);
        }

        return controller;
    }

    private FragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fm = activity.getFragmentManager();

        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PersonalDataFragment());
        //fragments.add(new UserFragment());

        FragmentTransaction transaction = fm.beginTransaction();

        for (Fragment fragment : fragments) {
            transaction.add(containerId, fragment);
        }

        transaction.commit();
    }

    //显示Fragment
    public void showFragment(int position) {
        hideFragments();

        Fragment fragment = fragments.get(position);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    //隐藏当前的fragment
    public void hideFragments() {
        FragmentTransaction transaction = fm.beginTransaction();

        for (Fragment fragment : fragments) {
            if (fragment != null) {
                transaction.hide(fragment);
            }
        }

        transaction.commit();
    }

    //获取Fragment
    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
