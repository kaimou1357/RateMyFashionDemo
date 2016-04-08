package com.nyu.mouzhang.ratemyfashiondemo.Adapter;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nyu.mouzhang.ratemyfashiondemo.Controller.TabFragment;

/**
 * Created by kai on 4/8/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public TabFragment getItem(int position){
        return new TabFragment();
    }
    @Override
    public int getCount(){
        return 2;
    }
}
