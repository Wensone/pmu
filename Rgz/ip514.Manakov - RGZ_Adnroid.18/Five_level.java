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

public class Five_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;

    private int line = -1;
    private boolean yesPressed = false;
    private boolean noPressed = false;
    private boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_level);
        final Button fiveYes1 = (Button) findViewById(R.id.fiveYes1); // 9
        final Button fiveNo1 = (Button) findViewById(R.id.fiveNo1);

        final TextView textView0 = (TextView) findViewById(R.id.textView0); // 1
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final TextView textView7 = (TextView) findViewById(R.id.textView7); // 8
        // buttons yes no
        final TextView textView8 = (TextView) findViewById(R.id.textView8); // 11
        final TextView textView9 = (TextView) findViewById(R.id.textView9);
        final TextView textView10 = (TextView) findViewById(R.id.textView10);
        final TextView textView11 = (TextView) findViewById(R.id.textView11);
        final TextView textView12 = (TextView) findViewById(R.id.textView12);
        final TextView textView13 = (TextView) findViewById(R.id.textView13);
        final TextView textView14 = (TextView) findViewById(R.id.textView14);
        final TextView textView15 = (TextView) findViewById(R.id.textView15);
        final TextView textView16 = (TextView) findViewById(R.id.textView16);
        final TextView textView17 = (TextView) findViewById(R.id.textView17);
        final TextView textView18 = (TextView) findViewById(R.id.textView18);
        final Button five_next_level = (Button) findViewById(R.id.fiveNextLevel);

        // заполнение текстов сценарием
        textView0.setText(Five_tabel.fivescenario[0]);
        textView1.setText(Five_tabel.fivescenario[1]);
        textView2.setText(Five_tabel.fivescenario[2]);
        textView3.setText(Five_tabel.fivescenario[3]);
        textView4.setText(Five_tabel.fivescenario[4]);
        textView5.setText(Five_tabel.fivescenario[5]);
        textView6.setText(Five_tabel.fivescenario[6]);
        textView7.setText(Five_tabel.fivescenario[7]);
        textView8.setText(Five_tabel.fivescenario[8]);
        textView9.setText(Five_tabel.fivescenario[9]);
        textView10.setText(Five_tabel.fivescenario[10]);
        textView11.setText(Five_tabel.fivescenario[11]);
        textView12.setText(Five_tabel.fivescenario[12]);
        textView13.setText(Five_tabel.fivescenario[13]);
        textView14.setText(Five_tabel.fivescenario[14]);
        textView15.setText(Five_tabel.fivescenario[15]);
        textView16.setText(Five_tabel.fivescenario[16]);
        textView17.setText(Five_tabel.fivescenario[17]);
        textView18.setText(Five_tabel.fivescenario[18]);

        fiveYes1.setVisibility(View.INVISIBLE);
        fiveNo1.setVisibility(View.INVISIBLE);
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
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);
        textView15.setVisibility(View.INVISIBLE);
        textView16.setVisibility(View.INVISIBLE);
        textView17.setVisibility(View.INVISIBLE);
        textView18.setVisibility(View.INVISIBLE);
        five_next_level.setVisibility(View.INVISIBLE);
        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Five_level.this, Four_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.d(MainActivity.e, "Переход в Four level");
        }
        finish();
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (line <= 20) {
                if ((!yesPressed && !noPressed) && line == 8) continue;

                publishProgress(line++);
                try {
                    Thread.sleep(250);
                    if (isCancelled()) return null;
                } catch (Exception e) {
                    Log.d(
                            MainActivity.e,
                            "Five thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            final Animation a = AnimationUtils.loadAnimation(Five_level.this, R.anim.alpha);

            final Button fiveYes1 = (Button) findViewById(R.id.fiveYes1); // 9
            final Button fiveNo1 = (Button) findViewById(R.id.fiveNo1);

            final TextView textView0 = (TextView) findViewById(R.id.textView0); // 1
            final TextView textView1 = (TextView) findViewById(R.id.textView1);
            final TextView textView2 = (TextView) findViewById(R.id.textView2);
            final TextView textView3 = (TextView) findViewById(R.id.textView3);
            final TextView textView4 = (TextView) findViewById(R.id.textView4);
            final TextView textView5 = (TextView) findViewById(R.id.textView5);
            final TextView textView6 = (TextView) findViewById(R.id.textView6);
            final TextView textView7 = (TextView) findViewById(R.id.textView7); // 8
            // buttons yes no
            final TextView textView8 = (TextView) findViewById(R.id.textView8); // 11
            final TextView textView9 = (TextView) findViewById(R.id.textView9);
            final TextView textView10 = (TextView) findViewById(R.id.textView10);
            final TextView textView11 = (TextView) findViewById(R.id.textView11);
            final TextView textView12 = (TextView) findViewById(R.id.textView12);
            final TextView textView13 = (TextView) findViewById(R.id.textView13);
            final TextView textView14 = (TextView) findViewById(R.id.textView14);
            final TextView textView15 = (TextView) findViewById(R.id.textView15);
            final TextView textView16 = (TextView) findViewById(R.id.textView16);
            final TextView textView17 = (TextView) findViewById(R.id.textView17);
            final TextView textView18 = (TextView) findViewById(R.id.textView18);

            final Button five_next_level = (Button) findViewById(R.id.fiveNextLevel);//22

            /*
                threeNo1.setVisibility(View.VISIBLE);
                        threeNo1.startAnimation(a);
                        threeNo1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                noPressed = true;
                                // сразу переходим к нужнам нам строкам (через 2)
                                line+=2;
                            }
                        });
            */

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
                    fiveYes1.setVisibility(View.VISIBLE);
                    fiveYes1.startAnimation(a);
                    fiveYes1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!noPressed) {
                                if (yesPressed) return;
                                yesPressed = true;
                                line++;
                                textView8.setVisibility(View.VISIBLE);
                                textView8.startAnimation(a);
                                textView9.setVisibility(View.VISIBLE);
                                textView9.startAnimation(a);
                                textView10.setVisibility(View.VISIBLE);
                                textView10.startAnimation(a);
                                textView11.setVisibility(View.VISIBLE);
                                textView11.startAnimation(a);

                                textView12.setVisibility(View.GONE);
                                textView13.setVisibility(View.GONE);
                            }
                        }
                    });

                    fiveNo1.setVisibility(View.VISIBLE);
                    fiveNo1.startAnimation(a);
                    fiveNo1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!yesPressed) {
                                if (noPressed) return;
                                noPressed = true;
                                line++;
                                textView12.setVisibility(View.VISIBLE);
                                textView12.startAnimation(a);
                                textView13.setVisibility(View.VISIBLE);
                                textView13.startAnimation(a);

                                textView8.setVisibility(View.GONE);
                                textView9.setVisibility(View.GONE);
                                textView10.setVisibility(View.GONE);
                                textView11.setVisibility(View.GONE);
                            }
                        }
                    });

                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    textView14.setVisibility(View.VISIBLE);
                    textView14.startAnimation(a);
                    break;
                case 16:
                    textView15.setVisibility(View.VISIBLE);
                    textView15.startAnimation(a);
                    break;
                case 17:
                    textView16.setVisibility(View.VISIBLE);
                    textView16.startAnimation(a);
                    break;
                case 18:
                    textView17.setVisibility(View.VISIBLE);
                    textView17.startAnimation(a);
                    break;
                case 19:
                    textView18.setVisibility(View.VISIBLE);
                    textView18.startAnimation(a);
                    break;
                case 20: {
                    five_next_level.setVisibility(View.VISIBLE);
                    five_next_level.startAnimation(a);
                    five_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            five_next_level.setBackgroundResource(R.drawable.read_next);
                            try {
                                Intent intent = new Intent(Five_level.this, Six_level.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                                Log.d(MainActivity.i, "Переход из Six level");
                            }
                        }
                    });
                }
                default:
                    break;
            }
        }
    }
}
