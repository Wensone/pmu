package com.example.u7er.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Main extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRead, btnClear;
    EditText etName, etWeight, etHeight;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);

        dbHelper = new DBHelper(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        String name = "Null obj";
        int weight = -1;
        int height = -1;
        int age = -1;

        boolean isParse = true;
        try {
            name = etName.getText().toString();
            weight = Integer.valueOf(etWeight.getText().toString());
            height = Integer.valueOf(etHeight.getText().toString());
            age = (int) (Math.random() * 60) + 30;
            if(name.length() > 10) name = name.substring(0, 10);

        } catch (Exception e) {
            isParse = false;
        }
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        @SuppressLint("WrongViewCast") TableLayout tableLayout = findViewById(R.id.table);

        switch (v.getId()) {
            case R.id.btnAdd:
                if(!isParse) break;

                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_WEIGHT, weight);
                contentValues.put(DBHelper.KEY_HEIGHT, height);
                contentValues.put(DBHelper.KEY_AGE, age);

                Log.d("mLog", "[Add] Name:" + name +
                        "\tWeight:" + weight +
                        "\tHeight:" + height +
                        "\tAge:" + age
                );

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btnRead:
                tableLayout.removeAllViewsInLayout();
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int nameIndex =     cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int weightIndex =   cursor.getColumnIndex(DBHelper.KEY_WEIGHT);
                    int heightIndex =   cursor.getColumnIndex(DBHelper.KEY_HEIGHT);
                    int ageIndex =      cursor.getColumnIndex(DBHelper.KEY_AGE);

                    do {

                        TextView textUser1 = new TextView(getApplicationContext());
                        textUser1.setText(cursor.getString(nameIndex));
                        textUser1.setTextColor(Color.BLACK);

                        TextView textUser2 = new TextView(getApplicationContext());
                        textUser2.setText(Integer.toString(cursor.getInt(weightIndex)));
                        textUser2.setTextColor(Color.BLACK);

                        TextView textUser3 = new TextView(getApplicationContext());
                        textUser3.setText(Integer.toString(cursor.getInt(heightIndex)));
                        textUser3.setTextColor(Color.BLACK);

                        TextView textUser4 = new TextView(getApplicationContext());
                        textUser4.setText(Integer.toString(cursor.getInt(ageIndex)));
                        textUser4.setTextColor(Color.BLACK);

                        TableRow row = new TableRow(getApplicationContext());

                        row.addView(textUser1);
                        row.addView(textUser2);
                        row.addView(textUser3);
                        row.addView(textUser4);

                        tableLayout.addView(row);

                        Log.d("mLog", "[Print] Name:" + cursor.getString(nameIndex) +
                                "\tWeight:" + cursor.getInt(weightIndex) +
                                "\tHeight:" + cursor.getInt(heightIndex) +
                                "\tAge:" + cursor.getInt(ageIndex)

                        );
                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog","0 rows");

                cursor.close();
                break;

            case R.id.btnClear:
                tableLayout.removeAllViewsInLayout();
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
        }
        dbHelper.close();
    }
}


class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "studentdb";
    public static final String TABLE_CONTACTS = "students";

    public static final String KEY_NAME = "name";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_AGE = "age";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +
                TABLE_CONTACTS +
                "(" +
                KEY_NAME +
                " text," +
                KEY_WEIGHT +
                " integer," +
                KEY_HEIGHT +
                " integer," +
                KEY_AGE +
                " integer primary key" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(db);

    }
}