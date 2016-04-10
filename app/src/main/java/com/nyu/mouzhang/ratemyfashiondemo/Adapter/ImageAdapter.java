package com.nyu.mouzhang.ratemyfashiondemo.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.nyu.mouzhang.ratemyfashiondemo.Controller.MainActivity;
import com.nyu.mouzhang.ratemyfashiondemo.R;
import com.squareup.picasso.Picasso;

/**
 * Created by kai on 4/10/16.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.with(mContext).load(mThumbIds[position]).resize(350,350).centerCrop().into(imageView);

        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
        R.drawable.model, R.drawable.model2,R.drawable.model3, R.drawable.model4



    };
}
