package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
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
    final static String USERNAME = "admin";
    final static String PASSWORD = "";
    final static String RTSP_URL = "rtsp://192.168.1.185/play1.sdp";

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private List<Recommendation> recList = new ArrayList<Recommendation>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        //viewPager = (ViewPager) findViewById(R.id.viewpager);


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        final TabLayout.Tab closet = tabLayout.newTab();
        final TabLayout.Tab recommendations = tabLayout.newTab();

        closet.setText("Closet");
        recommendations.setText("Recommendations");

        tabLayout.addTab(recommendations, 0);
        tabLayout.addTab(closet, 1);


        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));


//        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(this);
//        surfaceHolder.setFixedSize(320, 240);
        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



        /* Go ahead with the RecyclerView mock up

         */
        RecyclerView recommendationList = (RecyclerView) findViewById(R.id.recommendationCardList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recList.add(new Recommendation("Socks", "Sold at Macy's", R.drawable.socks));
        recList.add(new Recommendation("Bag", "Sold at Michael Kors", R.drawable.bag));
        recList.add(new Recommendation("Shirt", "Sold at H&M", R.drawable.stock));
        recList.add(new Recommendation("Pants", "Sold at Forever 21", R.drawable.stock2));

        final RecommendationListAdapter adapter = new RecommendationListAdapter(recList, getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recommendationList.setAdapter(adapter);
        recommendationList.setLayoutManager(llm);

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                // callback for drag-n-drop, false to skip this feature
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // callback for swipe to dismiss, removing item from data and adapter

                recList.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recommendationList);




    }
//    @Override
//    public void surfaceChanged(SurfaceHolder sh, int f, int w, int h){}
//    @Override
//    public void surfaceCreated(SurfaceHolder sh){
//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setDisplay(surfaceHolder);
//
//        Context context = getApplicationContext();
//        Map<String, String> headers = getRtspHeaders();
//        Uri source = Uri.parse(RTSP_URL);
//        try{
//            mediaPlayer.setDataSource(context, source, headers);
//            mediaPlayer.setOnPreparedListener(this);
//            mediaPlayer.prepareAsync();
//        }catch(Exception e){
//
//        }
//    }
//
//    @Override
//    public void onPrepared(MediaPlayer mp){
//        mediaPlayer.start();
//    }
//    @Override
//    public void surfaceDestroyed(SurfaceHolder sh){
//        mediaPlayer.release();
//    }
//
//    private Map<String, String> getRtspHeaders() {
//        Map<String, String> headers = new HashMap<String, String>();
//        String basicAuthValue = getBasicAuthValue(USERNAME, PASSWORD);
//        headers.put("Authorization", basicAuthValue);
//        return headers;
//    }
//
//    private String getBasicAuthValue(String usr, String pwd) {
//        String credentials = usr + ":" + pwd;
//        int flags = Base64.URL_SAFE | Base64.NO_WRAP;
//        byte[] bytes = credentials.getBytes();
//        return "Basic " + Base64.encodeToString(bytes, flags);
//    }


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
            Intent i = new Intent(this, CameraActivity.class);
            startActivity(i);


        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
