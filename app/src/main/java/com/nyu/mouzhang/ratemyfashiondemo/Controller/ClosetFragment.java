package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyu.mouzhang.ratemyfashiondemo.R;

/**
 * Created by kai on 4/10/16.
 */
public class ClosetFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.recommendation_fragment, container,false );
    }
}
