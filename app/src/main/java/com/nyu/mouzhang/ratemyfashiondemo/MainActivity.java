package com.nyu.mouzhang.ratemyfashiondemo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    final static String USERNAME = "admin";
    final static String PASSWORD = "";
    final static String RTSP_URL = "rtsp://192.168.1.185/play1.sdp";

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
//        surfaceHolder = surfaceView.getHolder();
//        surfaceHolder.addCallback(this);
//        surfaceHolder.setFixedSize(320, 240);

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

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}
