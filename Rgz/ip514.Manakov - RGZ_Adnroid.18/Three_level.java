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

public class Three_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;
    public TextView textView0;
    public ImageView threeImage1;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public Button threeYes1;
    public Button threeNo1;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public TextView textView7;
    public TextView textView8;
    public Button threeNextLevel;

    private int line = -1;
    private boolean yesPressed = false;
    private boolean noPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_level);

        final TextView textView0 = (TextView)findViewById(R.id.textView22);
        final ImageView threeImage1 = (ImageView)findViewById(R.id.threeImage1);
        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final TextView textView2 = (TextView)findViewById(R.id.textView2);
        final TextView textView3 = (TextView)findViewById(R.id.textView3);
        final Button threeYes1 = (Button)findViewById(R.id.threeYes1);
        final Button threeNo1 = (Button)findViewById(R.id.threeNo1);
        final TextView textView4 = (TextView)findViewById(R.id.textView4);
        final TextView textView5 = (TextView)findViewById(R.id.textView5);
        final TextView textView6 = (TextView)findViewById(R.id.textView6);
        final TextView textView7 = (TextView)findViewById(R.id.textView7);
        final TextView textView8 = (TextView)findViewById(R.id.textView8);
        final Button three_next_level = (Button)findViewById(R.id.threeNextLevel);

        textView0.setText(Three_tabel.threescenario[0]);
        textView1.setText(Three_tabel.threescenario[1]);
        textView2.setText(Three_tabel.threescenario[2]);
        textView3.setText(Three_tabel.threescenario[3]);
        textView4.setText(Three_tabel.threescenario[4]);
        textView5.setText(Three_tabel.threescenario[5]);
        textView6.setText(Three_tabel.threescenario[6]);
        textView7.setText(Three_tabel.threescenario[7]);
        textView8.setText(Three_tabel.threescenario[8]);

        textView0.setVisibility(View.INVISIBLE);
        threeImage1.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        threeYes1.setVisibility(View.INVISIBLE);
        threeNo1.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.GONE);
        textView5.setVisibility(View.GONE);
        textView6.setVisibility(View.GONE);
        textView7.setVisibility(View.GONE);
        textView8.setVisibility(View.GONE);
        three_next_level.setVisibility(View.INVISIBLE);
        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Three_level.this, Two_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
            Log.d(MainActivity.e, "Переход в Two level");
        }
        finish();
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (line <= 12) {
                if((!yesPressed || !noPressed) && line == 5) continue;
                if(yesPressed){
                    line--;
                    yesPressed = false;
                }
                publishProgress(line++);
                try {
                    Thread.sleep(250);
                    if (isCancelled()) return null;
                } catch (Exception e) {
                    Log.d(
                            MainActivity.e,
                            "Three thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            final Animation a = AnimationUtils.loadAnimation(Three_level.this, R.anim.alpha);

            final TextView textView0 = (TextView)findViewById(R.id.textView22);//0
            final TextView textView1 = (TextView)findViewById(R.id.textView1);//2
            final TextView textView2 = (TextView)findViewById(R.id.textView2);//3
            final TextView textView3 = (TextView)findViewById(R.id.textView3);//4
            final TextView textView4 = (TextView)findViewById(R.id.textView4);//6
            final TextView textView5 = (TextView)findViewById(R.id.textView5);//7
            final TextView textView6 = (TextView)findViewById(R.id.textView6);//8
            final TextView textView7 = (TextView)findViewById(R.id.textView7);//9
            final TextView textView8 = (TextView)findViewById(R.id.textView8);//10
            final ImageView threeImage1 = (ImageView)findViewById(R.id.threeImage1);//1
            final Button threeYes1 = (Button)findViewById(R.id.threeYes1);//5
            final Button threeNo1 = (Button)findViewById(R.id.threeNo1);//5
            final Button three_next_level = (Button)findViewById(R.id.threeNextLevel);//11

            switch(line){
                case 0: textView0.setVisibility(View.VISIBLE); textView0.startAnimation(a);break;
                case 1: threeImage1.setVisibility(View.VISIBLE); threeImage1.startAnimation(a);break;
                case 2: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a);break;
                case 3: textView2.setVisibility(View.VISIBLE); textView2.startAnimation(a);break;
                case 4: textView3.setVisibility(View.VISIBLE); textView3.startAnimation(a);break;
                case 5: threeYes1.setVisibility(View.VISIBLE); threeYes1.startAnimation(a);
                        threeYes1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                yesPressed = true;
                                // изменили значение зависшей строки, чтобы двинуться к некст кейсу
                                line++;
                            }
                        });
                        threeNo1.setVisibility(View.VISIBLE); threeNo1.startAnimation(a);
                        threeNo1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                noPressed = true;
                                // сразу переходим к нужнам нам строкам (через 2)
                                line+=2;
                            }
                        });

                        break;
                case 6:
                    textView6.setVisibility(View.GONE);
                    textView4.setVisibility(View.VISIBLE); textView4.startAnimation(a);break;
                case 7:
                    textView7.setVisibility(View.GONE);
                    // перескочили на такое кол-во строк дальше для скипа ненужных диалогов
                    line+=2;
                    textView5.setVisibility(View.VISIBLE); textView5.startAnimation(a);break;
                case 8:
                    textView4.setVisibility(View.GONE);
                    textView5.setVisibility(View.GONE);
                    textView6.setVisibility(View.VISIBLE); textView6.startAnimation(a);break;
                case 9: textView7.setVisibility(View.VISIBLE); textView7.startAnimation(a);break;
                case 10: textView8.setVisibility(View.VISIBLE); textView8.startAnimation(a);break;
                case 11: {
                    three_next_level.setVisibility(View.VISIBLE);
                    three_next_level.startAnimation(a);
                    three_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            three_next_level.setBackgroundResource(R.drawable.read_next);
                            try{
                                Intent intent = new Intent(Three_level.this, Four_level.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e){
                                Log.d(MainActivity.e, "Переход из Three level");
                            }
                        }
                    });
                }
                default: break;

            }
        }
    }
}
