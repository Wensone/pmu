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

public class Two_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;
    public TextView textView1; // 0
    public ImageView twoImage2; // картинка
    public TextView textView3; // 1
    public TextView textView4; // 2
    public TextView textView5; // 3
    public TextView textView6; // 4
    public Button two_next_level; // 5

    public int line = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_level);

        // инит текста
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final ImageView twoImage2 = (ImageView) findViewById(R.id.twoImage2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final Button two_next_level = (Button) findViewById(R.id.twoNextLevel);

        // Заполняем текст в разметке
        textView1.setText(Two_tabel.twoscenario[0]);
        // ImageTwoLevel
        textView3.setText(Two_tabel.twoscenario[1]);
        textView4.setText(Two_tabel.twoscenario[2]);
        textView5.setText(Two_tabel.twoscenario[3]);
        textView6.setText(Two_tabel.twoscenario[4]);

        // Сокрытие элементов
        textView1.setVisibility(View.INVISIBLE);
        twoImage2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        two_next_level.setVisibility(View.INVISIBLE);

        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Two_level.this, One_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
            Log.d(MainActivity.e, "Переход в One level");
        }
        finish();
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(line <= 6){
                publishProgress(line++);
                try{
                    Thread.sleep(250);
                    if(isCancelled()) return null;
                } catch(Exception e){
                    Log.d(
                            MainActivity.e,
                            "Two thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            final Animation a = AnimationUtils.loadAnimation(Two_level.this, R.anim.alpha);
            final TextView textView1 = (TextView) findViewById(R.id.textView1);
            final ImageView twoImage2 = (ImageView) findViewById(R.id.twoImage2);
            final TextView textView3 = (TextView) findViewById(R.id.textView3);
            final TextView textView4 = (TextView) findViewById(R.id.textView4);
            final TextView textView5 = (TextView) findViewById(R.id.textView5);
            final TextView textView6 = (TextView) findViewById(R.id.textView6);
            final Button two_next_level = (Button) findViewById(R.id.twoNextLevel);

            switch(line){
                case 1: textView1.setVisibility(View.VISIBLE);textView1.startAnimation(a); break;
                case 2: twoImage2.setVisibility(View.VISIBLE);twoImage2.startAnimation(a); break;
                case 3: textView3.setVisibility(View.VISIBLE);textView3.startAnimation(a); break;
                case 4: textView4.setVisibility(View.VISIBLE);textView4.startAnimation(a); break;
                case 5: textView5.setVisibility(View.VISIBLE);textView5.startAnimation(a); break;
                case 6: textView6.setVisibility(View.VISIBLE);textView6.startAnimation(a); break;
                case 7: {
                    two_next_level.setVisibility(View.VISIBLE);
                    two_next_level.startAnimation(a);
                    two_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            two_next_level.setBackgroundResource(R.drawable.read_next);
                            try{
                                Intent intent = new Intent(Two_level.this, Three_level.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e){
                                Log.d(MainActivity.e, "Переход из Two level");
                            }
                        }
                    });
                }
                default: break;
            }
        }
    }
}
