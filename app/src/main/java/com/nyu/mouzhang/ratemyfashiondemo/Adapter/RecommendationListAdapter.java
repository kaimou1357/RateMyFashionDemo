package com.nyu.mouzhang.ratemyfashiondemo.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nyu.mouzhang.ratemyfashiondemo.Controller.MainActivity;
import com.nyu.mouzhang.ratemyfashiondemo.Controller.RecommendationDetailFragment;
import com.nyu.mouzhang.ratemyfashiondemo.Model.Recommendation;
import com.nyu.mouzhang.ratemyfashiondemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kai on 4/8/16.
 */
public class RecommendationListAdapter extends RecyclerView.Adapter<RecommendationListAdapter.RecommendationViewHolder>{
    private List<Recommendation> recList;
    private Context context;

    public RecommendationListAdapter(List<Recommendation> recList, Context c){
        this.recList = recList;
        context = c;
    }
    @Override
    public int getItemCount(){
        return recList.size();
    }
    @Override
    public void onBindViewHolder(RecommendationViewHolder recommendationViewHolder, int i){
        final Recommendation r = recList.get(i);
        recommendationViewHolder.description1.setText(r.getDescription1());
        recommendationViewHolder.description2.setText(r.getDescription2());
        Picasso.with(context).load(r.getPhotoLink()).fit().into(recommendationViewHolder.recommendedPicture);
        recommendationViewHolder.recommendedPicture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                fragmentJump(r);
                Log.d("Fragment", "Fragment Jumped");
            }
        });

    }

    private void fragmentJump(Recommendation itemSelected){
        RecommendationDetailFragment frag = new RecommendationDetailFragment();
        Bundle b = new Bundle();
        b.putString("description1", itemSelected.getDescription1());
        b.putString("description2", itemSelected.getDescription2());
        b.putInt("photo", itemSelected.getPhotoLink());
        frag.setArguments(b);
        switchContent(R.id.container, frag);

    }
    public void switchContent(int id, RecommendationDetailFragment fragment) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            Fragment frag = fragment;
            mainActivity.switchContent(id, frag);
        }

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


