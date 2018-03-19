package com.example.u7er.bugs;

import android.graphics.Bitmap;


public class BugThread extends Thread {
    private GameView gameView;
    private Bug bug;
    private boolean running;

    BugThread(GameView view, Bitmap enemyBmp) {
        this.gameView = view;
        bug = new Bug(gameView, enemyBmp);
    }

    void setRunning(boolean run) {
        running = run;
    }

    @Override
    public void run() {
        while (running) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bug.update();
        }
    }

    Bug getBug() {
        return bug;
    }
}
