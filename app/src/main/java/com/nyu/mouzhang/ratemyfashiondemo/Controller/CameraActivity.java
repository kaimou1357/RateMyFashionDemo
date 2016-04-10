package com.nyu.mouzhang.ratemyfashiondemo.Controller;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.VideoView;

import com.nyu.mouzhang.ratemyfashiondemo.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kai on 4/8/16.
 */
public class CameraActivity  extends Activity implements MediaPlayer.OnPreparedListener, SurfaceHolder.Callback{
    final static String USERNAME = "kaimou";
    final static String PASSWORD = "adventure";
    final static String RTSP_URL = "rtsp://192.168.1.187/play2.sdp";

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_fragment);

        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(320, 240);
    }

    @Override
    public void surfaceChanged(SurfaceHolder sh, int f, int w, int h){}
    @Override
    public void surfaceCreated(SurfaceHolder sh){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDisplay(surfaceHolder);

        Context context = getApplicationContext();
        Uri source = Uri.parse(RTSP_URL);
        try{
            mediaPlayer.setDataSource(context, source);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync();
        }catch(Exception e){

        }
    }

    @Override
    public void onPrepared(MediaPlayer mp){
        mediaPlayer.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder sh){
        mediaPlayer.release();
    }

}
