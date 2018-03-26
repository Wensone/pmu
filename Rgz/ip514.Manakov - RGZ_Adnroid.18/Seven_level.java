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
import android.widget.TextView;

public class Seven_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;

    private int line = -1;
    private boolean yesPressed = false;
    private boolean noPressed = false;
    private boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seven_level);

        final Button sevenYes2        = (Button) findViewById(R.id.sevenYes2);
        final Button sevenNo2         = (Button) findViewById(R.id.sevenNo2);
        final Button sevenYes3        = (Button) findViewById(R.id.sevenYes3);
        final Button sevenNo3         = (Button) findViewById(R.id.sevenNo3);

        final TextView textView0  = (TextView)findViewById(R.id.textView0);
        final TextView textView1  = (TextView)findViewById(R.id.textView1);
        final TextView textView2  = (TextView)findViewById(R.id.textView2);
        final TextView textView3  = (TextView)findViewById(R.id.textView3);
        final TextView textView4  = (TextView)findViewById(R.id.textView4);
        final TextView textView5  = (TextView)findViewById(R.id.textView5);
        final TextView textView6  = (TextView)findViewById(R.id.textView6);
        final TextView textView7  = (TextView)findViewById(R.id.textView7);
        final TextView textView8  = (TextView)findViewById(R.id.textView8);
        final TextView textView9  = (TextView)findViewById(R.id.textView9);
        final TextView textView10 = (TextView)findViewById(R.id.textView10);
        final TextView textView11 = (TextView)findViewById(R.id.textView11);
        final TextView textView12 = (TextView)findViewById(R.id.textView12);
        final TextView textView13 = (TextView)findViewById(R.id.textView13);
        final TextView textView14 = (TextView)findViewById(R.id.textView14);
        final TextView textView15 = (TextView)findViewById(R.id.textView15);
        final TextView textView16 = (TextView)findViewById(R.id.textView16);
        final TextView textView17 = (TextView)findViewById(R.id.textView17);
        final TextView textView18 = (TextView)findViewById(R.id.textView18);
        final TextView textView19 = (TextView)findViewById(R.id.textView19);
        final TextView textView20 = (TextView)findViewById(R.id.textView20);
        final TextView textView21 = (TextView)findViewById(R.id.textView21);
        final TextView textView22 = (TextView)findViewById(R.id.textView22);
        final TextView textView23 = (TextView)findViewById(R.id.textView23);
        final TextView textView24 = (TextView)findViewById(R.id.textView24);
        final TextView textView25 = (TextView)findViewById(R.id.textView25);
        final TextView textView26 = (TextView)findViewById(R.id.textView26);
        final TextView textView27 = (TextView)findViewById(R.id.textView27);

        final Button seven_next_level = (Button) findViewById(R.id.sevenNextLevel);

        // заполнение текстов сценарием

        textView0  .setText(Seven_tabel.sevenscenario[0]);
        textView1  .setText(Seven_tabel.sevenscenario[1]);
        textView2  .setText(Seven_tabel.sevenscenario[2]);
        textView3  .setText(Seven_tabel.sevenscenario[3]);
        textView4  .setText(Seven_tabel.sevenscenario[4]);
        textView5  .setText(Seven_tabel.sevenscenario[5]);
        textView6  .setText(Seven_tabel.sevenscenario[6]);
        textView7  .setText(Seven_tabel.sevenscenario[7]);
        textView8  .setText(Seven_tabel.sevenscenario[8]);
        textView9  .setText(Seven_tabel.sevenscenario[9]);
        textView10 .setText(Seven_tabel.sevenscenario[10]);
        textView11 .setText(Seven_tabel.sevenscenario[11]);
        textView12 .setText(Seven_tabel.sevenscenario[12]);
        textView13 .setText(Seven_tabel.sevenscenario[13]);
        textView14 .setText(Seven_tabel.sevenscenario[14]);
        textView15 .setText(Seven_tabel.sevenscenario[15]);
        textView16 .setText(Seven_tabel.sevenscenario[16]);
        textView17 .setText(Seven_tabel.sevenscenario[17]);
        textView18 .setText(Seven_tabel.sevenscenario[18]);
        textView19 .setText(Seven_tabel.sevenscenario[19]);
        textView20 .setText(Seven_tabel.sevenscenario[20]);
        textView21 .setText(Seven_tabel.sevenscenario[21]);
        textView22 .setText(Seven_tabel.sevenscenario[22]);
        textView23 .setText(Seven_tabel.sevenscenario[23]);
        textView24 .setText(Seven_tabel.sevenscenario[24]);
        textView25 .setText(Seven_tabel.sevenscenario[25]);
        textView26 .setText(Seven_tabel.sevenscenario[26]);
        textView27 .setText(Seven_tabel.sevenscenario[27]);

        sevenYes2   .setVisibility(View.INVISIBLE);
        sevenNo2    .setVisibility(View.INVISIBLE);
        sevenYes3   .setVisibility(View.INVISIBLE);
        sevenNo3    .setVisibility(View.INVISIBLE);

        textView0  .setVisibility(View.INVISIBLE);
        textView1  .setVisibility(View.INVISIBLE);
        textView2  .setVisibility(View.INVISIBLE);
        textView3  .setVisibility(View.INVISIBLE);
        textView4  .setVisibility(View.INVISIBLE);
        textView5  .setVisibility(View.INVISIBLE);
        textView6  .setVisibility(View.INVISIBLE);
        textView7  .setVisibility(View.INVISIBLE);
        textView8  .setVisibility(View.INVISIBLE);
        textView9  .setVisibility(View.INVISIBLE);
        textView10 .setVisibility(View.INVISIBLE);
        textView11 .setVisibility(View.INVISIBLE);
        textView12 .setVisibility(View.INVISIBLE);
        textView13 .setVisibility(View.INVISIBLE);
        textView14 .setVisibility(View.INVISIBLE);
        textView15 .setVisibility(View.INVISIBLE);
        textView16 .setVisibility(View.INVISIBLE);
        textView17 .setVisibility(View.INVISIBLE);
        textView18 .setVisibility(View.INVISIBLE);
        textView19 .setVisibility(View.INVISIBLE);
        textView20 .setVisibility(View.INVISIBLE);
        textView21 .setVisibility(View.INVISIBLE);
        textView22 .setVisibility(View.INVISIBLE);
        textView23 .setVisibility(View.INVISIBLE);
        textView24 .setVisibility(View.INVISIBLE);
        textView25 .setVisibility(View.INVISIBLE);
        textView26 .setVisibility(View.INVISIBLE);
        textView27 .setVisibility(View.INVISIBLE);

        seven_next_level.setVisibility(View.INVISIBLE);
        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Seven_level.this, Six_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.d(MainActivity.e, "Переход в Six level");
        }
        finish();
    }

    public void resetPressed(){
        yesPressed = false;
        noPressed = false;
        isPressed = false;
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while (line <= 34) {
                if ((!yesPressed && !noPressed) && (line == 9 || line == 30)) continue;

                publishProgress(line++);
                try {
                    Thread.sleep(250);
                    if (isCancelled()) return null;
                } catch (Exception e) {
                    Log.d(
                            MainActivity.e,
                            "Seven thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            final Animation a = AnimationUtils.loadAnimation(Seven_level.this, R.anim.alpha);

            final Button sevenYes2        = (Button) findViewById(R.id.sevenYes2);
            final Button sevenNo2         = (Button) findViewById(R.id.sevenNo2);
            final Button sevenYes3        = (Button) findViewById(R.id.sevenYes3);
            final Button sevenNo3         = (Button) findViewById(R.id.sevenNo3);

            final TextView textView0  = (TextView)findViewById(R.id.textView0);
            final TextView textView1  = (TextView)findViewById(R.id.textView1);
            final TextView textView2  = (TextView)findViewById(R.id.textView2);
            final TextView textView3  = (TextView)findViewById(R.id.textView3);
            final TextView textView4  = (TextView)findViewById(R.id.textView4);
            final TextView textView5  = (TextView)findViewById(R.id.textView5);
            final TextView textView6  = (TextView)findViewById(R.id.textView6);
            final TextView textView7  = (TextView)findViewById(R.id.textView7);
            final TextView textView8  = (TextView)findViewById(R.id.textView8);
            final TextView textView9  = (TextView)findViewById(R.id.textView9);
            final TextView textView10 = (TextView)findViewById(R.id.textView10);

            final TextView textView11 = (TextView)findViewById(R.id.textView11);
            final TextView textView12 = (TextView)findViewById(R.id.textView12);

            final TextView textView13 = (TextView)findViewById(R.id.textView13);
            final TextView textView14 = (TextView)findViewById(R.id.textView14);
            final TextView textView15 = (TextView)findViewById(R.id.textView15);
            final TextView textView16 = (TextView)findViewById(R.id.textView16);

            final TextView textView17 = (TextView)findViewById(R.id.textView17);
            final TextView textView18 = (TextView)findViewById(R.id.textView18);

            final TextView textView19 = (TextView)findViewById(R.id.textView19);
            final TextView textView20 = (TextView)findViewById(R.id.textView20);
            final TextView textView21 = (TextView)findViewById(R.id.textView21);
            final TextView textView22 = (TextView)findViewById(R.id.textView22);
            final TextView textView23 = (TextView)findViewById(R.id.textView23);
            final TextView textView24 = (TextView)findViewById(R.id.textView24);

            final TextView textView25 = (TextView)findViewById(R.id.textView25);
            final TextView textView26 = (TextView)findViewById(R.id.textView26);

            final TextView textView27 = (TextView)findViewById(R.id.textView27);

            final Button seven_next_level = (Button) findViewById(R.id.sevenNextLevel);

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
                    resetPressed();
                    sevenYes2.setVisibility(View.VISIBLE);
                    sevenYes2.startAnimation(a);
                    sevenYes2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //if (!noPressed) {
                                if (yesPressed) return;
                                yesPressed = true;
                                line++;
                                // покаать нужное
                                textView9.setVisibility(View.VISIBLE);
                                textView9.startAnimation(a);
                                // скрыть ненужное
                                textView10.setVisibility(View.GONE);
                            //}
                        }
                    });

                    sevenNo2.setVisibility(View.VISIBLE);
                    sevenNo2.startAnimation(a);
                    sevenNo2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //if (!yesPressed) {
                                if (noPressed) return;
                                noPressed = true;
                                line++;
                                // покаать нужное
                                textView10.setVisibility(View.VISIBLE);
                                textView10.startAnimation(a);
                                // скрыть ненужное
                                textView9.setVisibility(View.GONE);
                            //}
                        }
                    });

                case 10: break;
                case 11:break;
                case 12:
                    textView11.setVisibility(View.VISIBLE);
                    textView11.startAnimation(a);
                    break;
                case 13:
                    textView12.setVisibility(View.VISIBLE);
                    textView12.startAnimation(a);
                    break;
                case 16:
                    textView13.setVisibility(View.VISIBLE);
                    textView13.startAnimation(a);
                    break;
                case 17:
                    textView14.setVisibility(View.VISIBLE);
                    textView14.startAnimation(a);
                    break;
                case 19:
                    textView14.setVisibility(View.VISIBLE);
                    textView14.startAnimation(a);
                    break;
                case 20:
                    textView15.setVisibility(View.VISIBLE);
                    textView15.startAnimation(a);
                    break;
                case 21:
                    textView16.setVisibility(View.VISIBLE);
                    textView16.startAnimation(a);
                    break;
                case 22:
                    textView17.setVisibility(View.VISIBLE);
                    textView17.startAnimation(a);
                    break;
                case 23:
                    textView18.setVisibility(View.VISIBLE);
                    textView18.startAnimation(a);
                    break;
                case 24:
                    textView19.setVisibility(View.VISIBLE);
                    textView19.startAnimation(a);
                    break;
                case 25:
                    textView20.setVisibility(View.VISIBLE);
                    textView20.startAnimation(a);
                    break;
                case 26:
                    textView21.setVisibility(View.VISIBLE);
                    textView21.startAnimation(a);
                    break;
                case 27:
                    textView22.setVisibility(View.VISIBLE);
                    textView22.startAnimation(a);
                    break;
                case 28:
                    textView23.setVisibility(View.VISIBLE);
                    textView23.startAnimation(a);
                    break;
                case 29:
                    textView24.setVisibility(View.VISIBLE);
                    textView24.startAnimation(a);
                    break;

                case 30:
                    resetPressed();
                    sevenYes3.setVisibility(View.VISIBLE);
                    sevenYes3.startAnimation(a);
                    sevenYes3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!noPressed) {
                                    if (yesPressed) return;
                                    yesPressed = true;
                                    line++;
                                    // покаать нужное
                                    textView25.setVisibility(View.VISIBLE);
                                    textView25.startAnimation(a);
                                    // скрыть ненужное
                                    textView26.setVisibility(View.GONE);
                                }
                            }
                        });

                    sevenNo3.setVisibility(View.VISIBLE);
                    sevenNo3.startAnimation(a);
                    sevenNo3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!yesPressed) {
                                    if (noPressed) return;
                                    noPressed = true;
                                    line++;
                                    // покаать нужное
                                    textView26.setVisibility(View.VISIBLE);
                                    textView26.startAnimation(a);
                                    // скрыть ненужное
                                    textView25.setVisibility(View.GONE);
                                }
                            }
                        });

                case 31:break;
                case 32:break;

                case 33:
                    textView27.setVisibility(View.VISIBLE);
                    textView27.startAnimation(a);
                    break;

                case 34: {
                    seven_next_level.setVisibility(View.VISIBLE);
                    seven_next_level.startAnimation(a);
                    seven_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            seven_next_level.setBackgroundResource(R.drawable.read_next);
                            try {
                                Intent intent = new Intent(Seven_level.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                                Log.d(MainActivity.i, "Переход из seven level");
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
