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

public class One_level extends AppCompatActivity {
    Delay delay_show_text = new Delay();
    public static Animation a;
    public TextView textView1;
    public TextView textView2;
    public ImageView oneImage3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public TextView textView7;
    public TextView textView8;
    public TextView textView9;
    public Button one_next_level;

    public int line = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_level);

        // инит текста
        final TextView textView1 = (TextView) findViewById(R.id.textView1);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        final ImageView oneImage3 = (ImageView) findViewById(R.id.oneImage3);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView6 = (TextView) findViewById(R.id.textView6);
        final TextView textView7 = (TextView) findViewById(R.id.textView7);
        final TextView textView8 = (TextView) findViewById(R.id.textView8);
        final TextView textView9 = (TextView) findViewById(R.id.textView9);

        final Button one_next_level = (Button) findViewById(R.id.oneNextLevel);

        // Заполняем текст в разметке
        textView1.setText(One_tabel.onescenario[0]);
        textView2.setText(One_tabel.onescenario[1]);
        // ImageOneLevel
        textView4.setText(One_tabel.onescenario[3]);
        textView5.setText(One_tabel.onescenario[4]);
        textView6.setText(One_tabel.onescenario[5]);
        textView7.setText(One_tabel.onescenario[6]);
        textView8.setText(One_tabel.onescenario[7]);
        textView9.setText(One_tabel.onescenario[8]);

        // Сокрытие элементов
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        oneImage3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        textView9.setVisibility(View.INVISIBLE);
        one_next_level.setVisibility(View.INVISIBLE);

        // Запуск AsyncTask
        delay_show_text.execute();
    }

    @Override
    public void onBackPressed(){
        delay_show_text.cancel(true);
        delay_show_text = null;
        try{
            Intent intent = new Intent(One_level.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e){
            Log.d(MainActivity.e, "Переход в Main");
        }
        finish();
    }

    // AsyncTask
    @SuppressLint("StaticFieldLeak")
    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(line <= 10){
                publishProgress(line++);
                try{
                   Thread.sleep(250);
                   if(isCancelled()) return null;
                } catch(Exception e){
                    Log.d(
                            MainActivity.e,
                            "One thread"
                    );
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            final Animation a = AnimationUtils.loadAnimation(One_level.this, R.anim.alpha);
            final TextView textView1 = (TextView) findViewById(R.id.textView1);
            final TextView textView2 = (TextView) findViewById(R.id.textView2);
            final ImageView oneImage3 = (ImageView) findViewById(R.id.oneImage3);
            final TextView textView4 = (TextView) findViewById(R.id.textView4);
            final TextView textView5 = (TextView) findViewById(R.id.textView5);
            final TextView textView6 = (TextView) findViewById(R.id.textView6);
            final TextView textView7 = (TextView) findViewById(R.id.textView7);
            final TextView textView8 = (TextView) findViewById(R.id.textView8);
            final TextView textView9 = (TextView) findViewById(R.id.textView9);
            final Button one_next_level = (Button) findViewById(R.id.oneNextLevel);

            switch(line){
                case 1: textView1.setVisibility(View.VISIBLE);textView1.startAnimation(a); break;
                case 2: textView2.setVisibility(View.VISIBLE);textView2.startAnimation(a); break;
                case 3: oneImage3.setVisibility(View.VISIBLE);oneImage3.startAnimation(a); break;
                case 4: textView4.setVisibility(View.VISIBLE);textView4.startAnimation(a); break;
                case 5: textView5.setVisibility(View.VISIBLE);textView5.startAnimation(a); break;
                case 6: textView6.setVisibility(View.VISIBLE);textView6.startAnimation(a); break;
                case 7: textView7.setVisibility(View.VISIBLE);textView7.startAnimation(a); break;
                case 8: textView8.setVisibility(View.VISIBLE);textView8.startAnimation(a); break;
                case 9: textView9.setVisibility(View.VISIBLE);textView9.startAnimation(a); break;
                case 10: {
                    one_next_level.setVisibility(View.VISIBLE);
                    one_next_level.startAnimation(a);
                    one_next_level.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Меняем картинку кнопки при нажатии
                            one_next_level.setBackgroundResource(R.drawable.read_next);
                            try{
                                Intent intent = new Intent(One_level.this, Two_level.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e){
                                Log.d(MainActivity.e, "Переход из One level");
                            }
                        }
                    });
                }
                default: break;
            }
        }
    }
}