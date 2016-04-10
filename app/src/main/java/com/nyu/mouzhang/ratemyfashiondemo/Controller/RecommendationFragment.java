package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyu.mouzhang.ratemyfashiondemo.Adapter.RecommendationListAdapter;
import com.nyu.mouzhang.ratemyfashiondemo.Model.Recommendation;
import com.nyu.mouzhang.ratemyfashiondemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kai on 4/10/16.
 */
public class RecommendationFragment extends Fragment {
    private List<Recommendation> recList = new ArrayList<Recommendation>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.recommendation_fragment, container,false );
        RecyclerView recommendationList = (RecyclerView) v.findViewById(R.id.recommendationCardList);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recList.add(new Recommendation("Socks", "Sold at Macy's", R.drawable.socks));
        recList.add(new Recommendation("Bag", "Sold at Michael Kors", R.drawable.bag));
        recList.add(new Recommendation("Shirt", "Sold at H&M", R.drawable.stock));
        recList.add(new Recommendation("Pants", "Sold at Forever 21", R.drawable.stock2));

        final RecommendationListAdapter adapter = new RecommendationListAdapter(recList, getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recommendationList.setAdapter(adapter);
        recommendationList.setLayoutManager(llm);

        return v;

    }
}
