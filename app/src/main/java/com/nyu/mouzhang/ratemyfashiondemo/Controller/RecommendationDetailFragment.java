package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nyu.mouzhang.ratemyfashiondemo.R;

import java.util.zip.Inflater;

/**
 * Created by kai on 4/10/16.
 */
public class RecommendationDetailFragment extends Fragment {
    private TextView description1;
    private TextView description2;
    private ImageView image;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.recommendation_detail, container, false);
        Bundle b = getArguments();
        description1 = (TextView) v.findViewById(R.id.description1);
        description2 = (TextView) v.findViewById(R.id.description2);
        image = (ImageView)v.findViewById(R.id.detailImageView);
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Snackbar.make(v, "Liked!", Snackbar.LENGTH_LONG).show();
            }
        });



        description1.setText(b.getString("description1"));
        description2.setText(b.getString("description2"));

        image.setImageResource(b.getInt("photo"));
        return v;
    }
}
