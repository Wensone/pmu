package ru.android.wallaqua;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.BatteryManager;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AquaWallpaperService extends WallpaperService {

    @Override
    public Engine onCreateEngine() {
        return new WallpaperEngine();
    }

    class WallpaperEngine extends Engine {

        private static final int MAX_COUNT = 8;

        private Handler mHandler = new Handler();

        private boolean visible = true;
        private boolean pause = false;

        private int width;
        private int height;
        private int batteryLevel = 100;
        private int waterLevel;

        private List<Fish> fishes = new ArrayList<>();

        private BroadcastReceiver receiver;

        private Bitmap bmpFish[];
        private Bitmap bmpDeadFish;
        private Bitmap bmpWater;
        private Bitmap bmpBottom;

        private Runnable drawRunner = new Runnable() {
            @Override
            public void run() {
                iteration();
                drawFrame();
            }
        };

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);

            bmpFish= new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.fishsimple),
                    BitmapFactory.decodeResource(getResources(), R.drawable.fishsimple1),
                    BitmapFactory.decodeResource(getResources(), R.drawable.fishsimple2)
            };
            bmpDeadFish = BitmapFactory.decodeResource(getResources(), R.drawable.dead);
            bmpWater = BitmapFactory.decodeResource(getResources(), R.drawable.water);
            bmpBottom = BitmapFactory.decodeResource(getResources(), R.drawable.bottom2);

            receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                    waterLevel = height / 100 * (100 - batteryLevel);
                    if (pause && height - waterLevel > bmpFish[0].getHeight()) {
                        pause = false;
                        iteration();
                        drawFrame();
                    }

                }
            };
            registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

            createFishes();

            iteration();
            drawFrame();
        }

        public void createFishes() {
            Random rand = new Random();

            for (int i = 0; i < MAX_COUNT; i++) {
                Bitmap bmtTemp=bmpFish[rand.nextInt(bmpFish.length)];
                fishes.add(i, new Fish(rand.nextInt(500), 1000 + bmtTemp.getHeight(), bmtTemp));
            }
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mHandler.removeCallbacks(drawRunner);
            fishes.clear();
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            this.visible = visible;
            if (visible) {
                iteration();
                drawFrame();
            } else {
                mHandler.removeCallbacks(drawRunner);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            this.width = width;
            this.height = height;

            iteration();
            drawFrame();
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);

            this.visible = false;
            mHandler.removeCallbacks(drawRunner);
        }

        void drawFrame() {
            if(!pause) {
                SurfaceHolder holder = getSurfaceHolder();
                Canvas c = null;
                try {
                    c = holder.lockCanvas();
                    if (c != null) {
                        draw(c);
                    }
                } finally {
                    if (c != null) {
                        holder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

        void draw(Canvas c) {
            c.save();

            c.drawColor(Color.BLACK);
            c.drawBitmap(bmpBottom, -100, height - bmpBottom.getHeight()+50, null);
            c.drawBitmap(bmpWater, 0, waterLevel, null);

            if (batteryLevel <35) {
                drawDead(c);
                pause = true;
            } else for (Fish fish : fishes) {
                fish.draw(c, height - waterLevel);
                fish.collision(0, waterLevel, width, height);
            }
            c.restore();
        }

        void drawDead(Canvas c) {
            Matrix matrix = new Matrix();

            Paint p = new Paint();
            p.setColor(Color.WHITE);
            p.setTextSize(90);
            c.drawText("Заряди меня", width / 5, height / 2, p);

            matrix.postTranslate(width / 2 + bmpDeadFish.getHeight() / 2, height - bmpDeadFish.getWidth());
            matrix.preRotate(90);
            c.drawBitmap(bmpDeadFish, matrix, null);

            matrix.reset();
            matrix.postTranslate(width / 2 + bmpDeadFish.getHeight() / 2, height - bmpDeadFish.getWidth());
            matrix.preRotate(50);
            c.drawBitmap(bmpDeadFish, matrix, null);

            matrix.reset();
            matrix.postTranslate(width / 2 - bmpDeadFish.getHeight() / 2, height - 0.8f * bmpDeadFish.getWidth());
            matrix.preRotate(-30);
            matrix.preScale(-1f, 1f);
            c.drawBitmap(bmpDeadFish, matrix, null);

            matrix.reset();
            matrix.postTranslate(width / 2 + bmpDeadFish.getHeight(), height - bmpDeadFish.getWidth());
            matrix.preRotate(40);
            c.drawBitmap(bmpDeadFish, matrix, null);

            matrix.reset();
            matrix.postTranslate(width / 2 - bmpDeadFish.getHeight() / 2, height - 1.4f * bmpDeadFish.getWidth());
            matrix.preRotate(-55);
            matrix.preScale(-1f, 1f);
            c.drawBitmap(bmpDeadFish, matrix, null);
        }

        void iteration() {
            mHandler.removeCallbacks(drawRunner);
            if (visible) {
                mHandler.postDelayed(drawRunner, 1000 / 25);
            }
        }
    }
}
