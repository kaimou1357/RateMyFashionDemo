package com.nyu.mouzhang.ratemyfashiondemo.Adapter;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nyu.mouzhang.ratemyfashiondemo.Model.Recommendation;
import com.nyu.mouzhang.ratemyfashiondemo.R;

import java.util.List;

/**
 * Created by kai on 4/8/16.
 */
public class RecommendationListAdapter extends RecyclerView.Adapter<RecommendationListAdapter.RecommendationViewHolder>{
    private List<Recommendation> recList;

    public RecommendationListAdapter(List<Recommendation> recList){
        this.recList = recList;
    }
    @Override
    public int getItemCount(){
        return recList.size();
    }
    @Override
    public void onBindViewHolder(RecommendationViewHolder recommendationViewHolder, int i){
        Recommendation r = recList.get(i);
        recommendationViewHolder.description1.setText(r.getDescription1());
        recommendationViewHolder.description2.setText(r.getDescription2());
        recommendationViewHolder.recommendedPicture.setImageResource(r.getPhotoID());

    }
    public RecommendationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recommendation_card, viewGroup, false);
        return new RecommendationViewHolder(itemView);
    }



    public static class RecommendationViewHolder extends RecyclerView.ViewHolder{
        protected TextView description1;
        protected TextView description2;
        protected ImageView recommendedPicture;

        public RecommendationViewHolder(View v){
            super(v);
            description1 = (TextView) v.findViewById(R.id.description1);
            description2 = (TextView) v.findViewById(R.id.description2);
            recommendedPicture = (ImageView) v.findViewById(R.id.recommendationImageView);
        }
    }

}


