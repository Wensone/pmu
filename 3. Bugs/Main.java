package com.example.u7er.bugs;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;

public class Main extends AppCompatActivity {
    GameView viewThread;
    public static int W, H;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        H = size.x;
        W = size.y;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        try {
            play(this, R.raw.backsound);
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewThread = new GameView(Main.this);
        setContentView(viewThread);
    }

    private void play(Context context, int resid) throws IOException {
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(resid);
        if (afd == null)
            return;
        MediaPlayer player = new MediaPlayer();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0.5f, 0.5f);
                mp.setLooping(true);
                mp.start();
            }
        });
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
        afd.close();
        player.prepareAsync();
    }
}
