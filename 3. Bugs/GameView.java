package com.example.u7er.bugs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
    private GameThread mThread;
    private List<BugThread> enemy;

    private Bitmap enemies;
    public Bitmap[] bmpMasKilled;

    int[] soundKilled = {R.raw.trash3, R.raw.trash1, R.raw.trash2, R.raw.trash4};
    public SoundPool sTab;
    int[] sondTab = new int[4];

    int score = 10;
    public float count = 0;
    public int tabX;
    public int tabY;
    float koef = 0.9f;
    float tempCount = 0;

    Vector<Pair<Bitmap, Pair<Integer, Integer>>> hm = new Vector<>();


    Thread th = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (1800 * koef) + 500);
                    createEnemies();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Thread timer = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    count += 0.1;
                    if (count - tempCount > 5) {
                        koef *= koef;
                        tempCount = count;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public GameView(final Context context) {
        super(context);
        enemy = new ArrayList<>();
        mThread = new GameThread(this);
        sTab = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        th.start();
        timer.start();
        for (int i = 0; i < sondTab.length; ++i) {
            sondTab[i] = sTab.load(context, soundKilled[i], 1);
        }
        enemies = BitmapFactory.decodeResource(getResources(), R.drawable.bug48);
        bmpMasKilled = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.bloodhand)
        };

        getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceDestroyed(SurfaceHolder holder) {
                mThread.setRunning(false);
                try {
                    mThread.join();
                } catch (InterruptedException ignored) {
                }
            }

            public void surfaceCreated(SurfaceHolder holder) {
                mThread.setRunning(true);
                mThread.start();
            }

            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (hm.size() > 10) {
            hm.remove(1);
        }
        for (Pair<Bitmap, Pair<Integer, Integer>> v : hm) {
            canvas.drawBitmap(v.getLeft(), v.getRight().getLeft(), v.getRight().getRight(), null);
        }

        for (BugThread e : enemy) {
            e.getBug().onDraw(canvas);
        }

        Paint paint = new Paint();
        paint.setTextSize(50);
        count = Math.round(count * 100) / 100.0f;
        canvas.drawText(String.valueOf(count), 100, 100, paint);
        canvas.drawText(String.valueOf(score - enemy.size()), 100, 200, paint);
        if (enemy.size() > 10) {
            paint.setTextSize(50);
            canvas.drawColor(Color.WHITE);
            canvas.drawText("You score:", 400, 340, paint);
            canvas.drawText(String.valueOf(count) + " seconds", 400, 400, paint);
            enemy.clear();
            mThread.setRunning(false);
        }
    }

    public boolean onTouchEvent(MotionEvent e) {
        Random rnd = new Random();
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            tabX = (int) e.getX();
            tabY = (int) e.getY();
            for (BugThread th : enemy) {
                if (tabX >= th.getBug().x && tabX <= th.getBug().x + th.getBug().width &&
                        tabY >= th.getBug().y && tabY <= th.getBug().y + th.getBug().height) {
                    th.setRunning(false);
                    Pair p = new Pair<>(th.getBug().x, th.getBug().y);
                    Pair t = new Pair<>(bmpMasKilled[rnd.nextInt(bmpMasKilled.length)], p);
                    hm.add(t);
                    enemy.remove(th);
                    this.sTab.play(sondTab[rnd.nextInt(sondTab.length)], 1f, 1f, 0, 0, 1.0f);
                    break;
                }
            }
        }
        return true;
    }

    public void createEnemies() {
        BugThread et = new BugThread(this, enemies);
        et.setRunning(true);
        et.start();
        enemy.add(et);
    }

}