package com.example.sergei.a02myjsonparser.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei on 23.01.2017.
 */

public class ViewPagerEVRO2016 extends FragmentPagerAdapter {
    Map<Integer, FragmentView> fragmentsMap = new HashMap<>();


    public ViewPagerEVRO2016(FragmentManager fm) {
        super(fm);
    }

    // Очевидно
    public void addFragment(Integer position, FragmentView fragment){
        fragmentsMap.put(position,fragment);
        Log.i("Info", "addNewFragmemt");

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsMap.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsMap.size();
    }

    // Для отображения заголовков
    @Override
    public CharSequence getPageTitle(int position){
        return fragmentsMap.get(position).getTitle();
    }

}
