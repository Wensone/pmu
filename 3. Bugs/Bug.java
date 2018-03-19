package com.example.u7er.bugs;


import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bug {
    public int x;
    public int y;

    public int speedx, speedy;

    public int width;
    public int height;

    public GameView gameView;
    public Bitmap bmp;

    public Bug(GameView gameView, Bitmap bmp) {
        this.gameView = gameView;
        this.bmp = bmp;
        Random rnd = new Random();
        this.x = rnd.nextInt(Main.H - 200);
        this.y = rnd.nextInt(Main.W - 300);

        this.speedx = rnd.nextInt(16) - 8;
        this.speedy = rnd.nextInt(16) - 8;

        this.width = 144;
        this.height = 144;
    }

    public void update() {
        x -= speedx;
        y -= speedy;
    }


    public void onDraw(Canvas c) {
        c.drawBitmap(bmp, x, y, null);
        if ((x > c.getWidth() - width || x < 0)) {
            speedx *= -1;
            if (speedx > 0) {
                x -= 10;
            } else {
                x += 10;
            }
        }
        if (y > c.getHeight() - height || y < 0) {
            speedy *= -1;
            if (speedy > 0) {
                y -= 10;
            } else {
                y += 10;
            }
        }
    }
}

