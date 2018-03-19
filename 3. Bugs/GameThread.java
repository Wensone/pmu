package com.example.u7er.bugs;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.net.wifi.p2p.WifiP2pManager;

import java.util.Timer;

public class GameThread extends Thread {
    Canvas canvas;
    boolean running = false;
    private GameView view;

    GameThread(final GameView view) {
        this.view = view;
    }

    void setRunning(boolean run) {
        running = run;
    }

    @SuppressLint("WrongCall")
    public void run() {
        while (running) {
            canvas = null;
            try {
                canvas = view.getHolder().lockCanvas();
                synchronized (view.getHolder()) {
                    view.onDraw(canvas);
                }
            } catch (Exception ignored) {
            } finally {
                if (canvas != null) {
                    view.getHolder().unlockCanvasAndPost(canvas);
                }
            }

        }
    }
}