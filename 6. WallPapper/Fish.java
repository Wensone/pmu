package ru.android.wallaqua;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.Random;


public class Fish {

    public int x;
    public int y;
    public int width;
    public int height;
    public float dx;
    public float dy;
    private Bitmap bmp;

    public Fish(int x, int y, Bitmap bmp){
        this.x = x;
        this.y = y;

        Random rnd = new Random();
        this.dx = rnd.nextFloat()*5 + 2;
        if(rnd.nextInt(100) < 50){
            this.dx = -this.dx;
        }
        this.dy = rnd.nextFloat()*1 + 1;

        this.bmp = bmp;

        width = bmp.getWidth();
        height = bmp.getHeight();
    }

    public void update(int highLevel){
        if(isDead(highLevel)) return;
        x+=dx;
        y+=dy;
    }

    public void draw(Canvas c, int highLevel){
        update(highLevel);
        Matrix matrix = new Matrix();
        if(dx > 0) matrix.preScale(-1f, 1f);
        matrix.postTranslate(x, y);
        c.drawBitmap(bmp, matrix, null);
    }

    public void collision(int left, int top, int right, int bottom){
        Random rnd = new Random();
        if(x + width <= left && dx < 0 || x - width >= right && dx > 0) dx = -dx/Math.abs(dx) * (rnd.nextFloat()*5 + 2);
        if(y <= top && dy < 0 || y + height >= bottom && dy > 0) dy = -dy/Math.abs(dy) * (rnd.nextFloat()*1 + 1);
    }

    public boolean isDead(int deadLevel){
        return deadLevel <= height;
    }
}
