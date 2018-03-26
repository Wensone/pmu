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

public class Six_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;

    private int line = -1;
    private boolean yesPressed = false;
    private boolean noPressed = false;
    private boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.six_level);

        final Button sixYes1        = (Button) findViewById(R.id.sixYes1);
        final Button sixNo1         = (Button) findViewById(R.id.sixNo1);
        final Button sixYes2        = (Button) findViewById(R.id.sixYes2);
        final Button sixNo2         = (Button) findViewById(R.id.sixNo2);
        final Button sixList1       = (Button) findViewById(R.id.sixYes3);
        final Button sixVector1     = (Button) findViewById(R.id.sixNo3);

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

        final Button five_next_level = (Button) findViewById(R.id.fiveNextLevel);

        // заполнение текстов сценарием

        textView0  .setText(Six_tabel.sixscenario[0]);
        textView1  .setText(Six_tabel.sixscenario[1]);
        textView2  .setText(Six_tabel.sixscenario[2]);
        textView3  .setText(Six_tabel.sixscenario[3]);
        textView4  .setText(Six_tabel.sixscenario[4]);
        textView5  .setText(Six_tabel.sixscenario[5]);
        textView6  .setText(Six_tabel.sixscenario[6]);
        textView7  .setText(Six_tabel.sixscenario[7]);
        textView8  .setText(Six_tabel.sixscenario[8]);
        textView9  .setText(Six_tabel.sixscenario[9]);
        textView10 .setText(Six_tabel.sixscenario[10]);
        textView11 .setText(Six_tabel.sixscenario[11]);
        textView12 .setText(Six_tabel.sixscenario[12]);
        textView13 .setText(Six_tabel.sixscenario[13]);
        textView14 .setText(Six_tabel.sixscenario[14]);
        textView15 .setText(Six_tabel.sixscenario[15]);
        textView16 .setText(Six_tabel.sixscenario[16]);
        textView17 .setText(Six_tabel.sixscenario[17]);
        textView18 .setText(Six_tabel.sixscenario[18]);
        textView19 .setText(Six_tabel.sixscenario[19]);
        textView20 .setText(Six_tabel.sixscenario[20]);
        textView21 .setText(Six_tabel.sixscenario[21]);
        textView22 .setText(Six_tabel.sixscenario[22]);
        textView23 .setText(Six_tabel.sixscenario[23]);
        textView24 .setText(Six_tabel.sixscenario[24]);
        textView25 .setText(Six_tabel.sixscenario[25]);
        textView26 .setText(Six_tabel.sixscenario[26]);
        textView27 .setText(Six_tabel.sixscenario[27]);

        sixYes1   .setVisibility(View.INVISIBLE);
        sixNo1    .setVisibility(View.INVISIBLE);
        sixYes2   .setVisibility(View.INVISIBLE);
        sixNo2    .setVisibility(View.INVISIBLE);
        sixList1  .setVisibility(View.INVISIBLE);
        sixVector1.setVisibility(View.INVISIBLE);

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

        five_next_level.setVisibility(View.INVISIBLE);
        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Six_level.this, Four_level.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Log.d(MainActivity.e, "Переход в Four level");
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
            while (line <= 31) {
                if ((!yesPressed && !noPressed) && (line == 11 || line == 18 || line == 27 )) continue;

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
            final Animation a = AnimationUtils.loadAnimation(Six_level.this, R.anim.alpha);

            final Button sixYes1        = (Button) findViewById(R.id.sixYes1);
            final Button sixNo1         = (Button) findViewById(R.id.sixNo1);
            final Button sixYes2        = (Button) findViewById(R.id.sixYes2);
            final Button sixNo2         = (Button) findViewById(R.id.sixNo2);
            final Button sixYes3       = (Button) findViewById(R.id.sixYes3);
            final Button sixNo3     = (Button) findViewById(R.id.sixNo3);

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

            final Button six_next_level = (Button) findViewById(R.id.fiveNextLevel);



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
                    resetPressed();
                    sixYes1.setVisibility(View.VISIBLE);
                    sixYes1.startAnimation(a);
                    sixYes1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!noPressed) {
                                if (yesPressed) return;
                                yesPressed = true;
                                line++;
                                // покаать нужное
                                textView11.setVisibility(View.VISIBLE);
                                textView11.startAnimation(a);
                                // скрыть ненужное
                                textView12.setVisibility(View.GONE);
                            }
                        }
                    });

                    sixNo1.setVisibility(View.VISIBLE);
                    sixNo1.startAnimation(a);
                    sixNo1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!yesPressed) {
                                if (noPressed) return;
                                noPressed = true;
                                line++;
                                // покаать нужное
                                textView12.setVisibility(View.VISIBLE);
                                textView12.startAnimation(a);
                                // скрыть ненужное
                                textView11.setVisibility(View.GONE);
                            }
                        }
                    });

                case 12:break;
                case 13:break;

                case 14:
                    textView13.setVisibility(View.VISIBLE);
                    textView13.startAnimation(a);
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
                    resetPressed();
                    sixYes2.setVisibility(View.VISIBLE);
                    sixYes2.startAnimation(a);
                    sixYes2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!noPressed) {
                                if (yesPressed) return;
                                yesPressed = true;
                                line++;
                                // покаать нужное
                                textView17.setVisibility(View.VISIBLE);
                                textView17.startAnimation(a);
                                // скрыть ненужное
                                textView18.setVisibility(View.GONE);
                            }
                        }
                    });

                    sixNo2.setVisibility(View.VISIBLE);
                    sixNo2.startAnimation(a);
                    sixNo2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (!yesPressed) {
                                if (noPressed) return;
                                noPressed = true;
                                line++;
                                // покаать нужное
                                textView18.setVisibility(View.VISIBLE);
                                textView18.startAnimation(a);
                                // скрыть ненужное
                                textView17.setVisibility(View.GONE);
                            }
                        }
                    });

                case 19:break;
                case 20:break;
                case 21:
                    textView19.setVisibility(View.VISIBLE);
                    textView19.startAnimation(a);
                    break;
                case 22:
                    textView20.setVisibility(View.VISIBLE);
                    textView20.startAnimation(a);
                    break;
                case 23:
                    textView21.setVisibility(View.VISIBLE);
                    textView21.startAnimation(a);
                    break;
                case 24:
                    textView22.setVisibility(View.VISIBLE);
                    textView22.startAnimation(a);
                    break;
                case 25:
                    textView23.setVisibility(View.VISIBLE);
                    textView23.startAnimation(a);
                    break;
                case 26:
                    textView24.setVisibility(View.VISIBLE);
                    textView24.startAnimation(a);
                    break;

                case 27:
                    resetPressed();
                    sixYes3.setVisibility(View.VISIBLE);
                    sixYes3.startAnimation(a);
                    sixYes3.setOnClickListener(new View.OnClickListener() {
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

                    sixNo3.setVisibility(View.VISIBLE);
                    sixNo3.startAnimation(a);
                    sixNo3.setOnClickListener(new View.OnClickListener() {
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

                case 28:break;
                case 29:break;

                case 30:
                    textView27.setVisibility(View.VISIBLE);
                    textView27.startAnimation(a);
                    break;

                case 31: {
                    six_next_level.setVisibility(View.VISIBLE);
                    six_next_level.startAnimation(a);
                    six_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            six_next_level.setBackgroundResource(R.drawable.read_next);
                            try {
                                Intent intent = new Intent(Six_level.this, Seven_level.class);
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
