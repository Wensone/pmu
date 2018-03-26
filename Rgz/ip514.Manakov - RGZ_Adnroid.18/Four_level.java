package com.example.u7er.commander;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Four_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;


    public Button fourNextLevel;

    private int line = -1;
    private boolean yesPressed = false;
    private boolean noPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_level);

        final TextView textView0 = (TextView) findViewById(R.id.textView0);
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final TextView textView7 = (TextView) findViewById(R.id.textView7);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);
        final TextView textView9 = (TextView) findViewById(R.id.textView9);
        final TextView textView10 = (TextView) findViewById(R.id.textView10);
        final TextView textView11 = (TextView) findViewById(R.id.textView11);
        final Button four_next_level = (Button) findViewById(R.id.fourNextLevel);


        textView0.setText(Four_tabel.fourscenario[0]);
        textView1.setText(Four_tabel.fourscenario[1]);
        textView2.setText(Four_tabel.fourscenario[2]);
        textView3.setText(Four_tabel.fourscenario[3]);
        textView4.setText(Four_tabel.fourscenario[4]);
        textView5.setText(Four_tabel.fourscenario[5]);
        textView6.setText(Four_tabel.fourscenario[6]);
        textView7.setText(Four_tabel.fourscenario[7]);
        textView8.setText(Four_tabel.fourscenario[8]);
        textView9.setText(Four_tabel.fourscenario[9]);
        textView10.setText(Four_tabel.fourscenario[10]);
        textView11.setText(Four_tabel.fourscenario[11]);

        textView0.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        textView9.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        four_next_level.setVisibility(View.INVISIBLE);
        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Four_level.this, Three_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.d(MainActivity.e, "Переход в Three level");
        }
        finish();
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (line <= 12) {
                publishProgress(line++);
                try {
                    Thread.sleep(250);
                    if (isCancelled()) return null;
                } catch (Exception e) {
                    Log.d(
                            MainActivity.e,
                            "Four thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            final Animation a = AnimationUtils.loadAnimation(Four_level.this, R.anim.alpha);

            final TextView textView0 = (TextView) findViewById(R.id.textView0);
            final TextView textView1 = (TextView) findViewById(R.id.textView1);
            final TextView textView2 = (TextView) findViewById(R.id.textView2);
            final TextView textView3 = (TextView) findViewById(R.id.textView3);
            final TextView textView4 = (TextView) findViewById(R.id.textView4);
            final TextView textView5 = (TextView) findViewById(R.id.textView5);
            final TextView textView6 = (TextView) findViewById(R.id.textView6);
            final TextView textView7 = (TextView) findViewById(R.id.textView7);
            final TextView textView8 = (TextView) findViewById(R.id.textView8);
            final TextView textView9 = (TextView) findViewById(R.id.textView9);
            final TextView textView10 = (TextView) findViewById(R.id.textView10);
            final TextView textView11 = (TextView) findViewById(R.id.textView11);
            final Button four_next_level = (Button) findViewById(R.id.fourNextLevel);

            switch (line) {
                case 0:
                    textView0.setVisibility(View.VISIBLE);
                    textView0.startAnimation(a);
                    break;
                case 1:
                    textView1.setVisibility(View.VISIBLE);
                    textView1.startAnimation(a);
                    break;
                case 2:
                    textView2.setVisibility(View.VISIBLE);
                    textView2.startAnimation(a);
                    break;
                case 3:
                    textView3.setVisibility(View.VISIBLE);
                    textView3.startAnimation(a);
                    break;
                case 4:
                    textView4.setVisibility(View.VISIBLE);
                    textView4.startAnimation(a);
                    break;
                case 5:
                    textView5.setVisibility(View.VISIBLE);
                    textView5.startAnimation(a);
                    break;
                case 6:
                    textView6.setVisibility(View.VISIBLE);
                    textView6.startAnimation(a);
                    break;
                case 7:
                    textView7.setVisibility(View.VISIBLE);
                    textView7.startAnimation(a);
                    break;
                case 8:
                    textView8.setVisibility(View.VISIBLE);
                    textView8.startAnimation(a);
                    break;
                case 9:
                    textView9.setVisibility(View.VISIBLE);
                    textView9.startAnimation(a);
                    break;
                case 10:
                    textView10.setVisibility(View.VISIBLE);
                    textView10.startAnimation(a);
                    break;
                case 11:
                    textView11.setVisibility(View.VISIBLE);
                    textView11.startAnimation(a);
                    break;
                case 12:
                    four_next_level.setVisibility(View.VISIBLE);
                    four_next_level.startAnimation(a);
                    four_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            four_next_level.setBackgroundResource(R.drawable.read_next);
                            try{
                                Intent intent = new Intent(Four_level.this, Five_level.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e){
                                Log.d(MainActivity.e, "Переход из Four level");
                            }
                        }
                    });

                default:
                    break;

            }
        }
    }
}
