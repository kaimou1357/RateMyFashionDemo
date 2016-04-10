package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.Menu;
import android.view.MenuItem;

import com.nyu.mouzhang.ratemyfashiondemo.Adapter.RecommendationListAdapter;
import com.nyu.mouzhang.ratemyfashiondemo.Adapter.ViewPagerAdapter;
import com.nyu.mouzhang.ratemyfashiondemo.Model.Recommendation;
import com.nyu.mouzhang.ratemyfashiondemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private NestedScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        scrollView = (NestedScrollView) findViewById(R.id.nestedScroll);
        scrollView.setFillViewport(true);


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        final TabLayout.Tab closet = tabLayout.newTab();
        final TabLayout.Tab recommendations = tabLayout.newTab();

        closet.setText("Closet");
        recommendations.setText("Recommendations");

        tabLayout.addTab(recommendations, 0);
        tabLayout.addTab(closet, 1);


        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        /* Go ahead with the RecyclerView mock up

         */


//        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
//                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                // callback for drag-n-drop, false to skip this feature
//                return false;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                // callback for swipe to dismiss, removing item from data and adapter
//
//                recList.remove(viewHolder.getAdapterPosition());
//                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
//            }
//        });
//        swipeToDismissTouchHelper.attachToRecyclerView(recommendationList);

    }
    public void switchContent(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(id, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.add_picture){
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);


        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
