package com.example.u7er.tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class OneActivity extends Activity {
    private ImageButton imageButton;
    private boolean isSwapGomer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_1);

        imageButton = (ImageButton) findViewById(R.id.oneGomer);
        imageButton.setImageResource(R.drawable.gomer);
    }

    public void swapGomer(View view) {
        if(!isSwapGomer){
            imageButton.setImageResource(R.drawable.marge);
            isSwapGomer = true;
        } else {
            imageButton.setImageResource(R.drawable.gomer);
            isSwapGomer = false;
        }

    }
}