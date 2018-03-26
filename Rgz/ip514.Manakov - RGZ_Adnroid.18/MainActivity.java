package com.example.u7er.commander;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String e = "[error] ";
    static final String i = "[info] ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем картинку кнопки при нажатии
                startGameButton.setBackgroundResource(R.drawable.start_game);
                try{
                    Intent intent = new Intent(MainActivity.this, One_level.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){
                    Log.d(MainActivity.e, "Next activity");
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        Log.d(MainActivity.e, "Exit of main");
        finish();
    }
}
