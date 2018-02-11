package com.example.u7er.calc;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import java.math.BigDecimal;
import java.lang.*;

public class Calc extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    protected static EditText SourceEdit;
    protected static String LocalEdit;

    private boolean isCalculate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        SourceEdit = (EditText) findViewById(R.id.calc_string);
        SourceEdit.setInputType(InputType.TYPE_NULL);

        LocalEdit = SourceEdit.getText().toString();
        SourceEdit.setText(LocalEdit);
    }

    public void CalculationExpression(View v) {
        String expression = SourceEdit.getText().toString();
        if (expression.length() == 0 || !isCalculate) return;

        double res_numb = RPN.Calculate(expression);
        String str = Double.toString(res_numb);
/*
        BigDecimal n = new BigDecimal(str);
        str = n.toPlainString();
*/
        LocalEdit = str;
        SourceEdit.setText(str);
    }

    private void setTextInSourceWindow() {
        SourceEdit.setText(LocalEdit);
        isCalculate = true;
    }

    public void add_0(View v) {
        LocalEdit += "0";
        setTextInSourceWindow();
    }

    public void add_1(View v) {
        LocalEdit += "1";
        setTextInSourceWindow();
    }

    public void add_2(View v) {
        LocalEdit += "2";
        setTextInSourceWindow();
    }

    public void add_3(View v) {
        LocalEdit += "3";
        setTextInSourceWindow();
    }

    public void add_4(View v) {
        LocalEdit += "4";
        setTextInSourceWindow();
    }

    public void add_5(View v) {
        LocalEdit += "5";
        setTextInSourceWindow();
    }

    public void add_6(View v) {
        LocalEdit += "6";
        setTextInSourceWindow();
    }

    public void add_7(View v) {
        LocalEdit += "7";
        setTextInSourceWindow();
    }

    public void add_8(View v) {
        LocalEdit += "8";
        setTextInSourceWindow();
    }

    public void add_9(View v) {
        LocalEdit += "9";
        setTextInSourceWindow();
    }

    public void add_Plus(View v) {
        if(LocalEdit.length() >= 1){
            if(LocalEdit.charAt(LocalEdit.length() - 1) == '+'){
                return;
            }
        }
        LocalEdit += "+";
        setTextInSourceWindow();
    }

    public void add_Minus(View v) {
        if(LocalEdit.length() >= 1){
            if(LocalEdit.charAt(LocalEdit.length() - 1) == '-'){
                return;
            }
        }
        LocalEdit += "-";
        setTextInSourceWindow();
    }

    public void add_Divide(View v) {
        if(LocalEdit.length() >= 1){
            if(LocalEdit.charAt(LocalEdit.length() - 1) == '/'){
                return;
            }
        }
        LocalEdit += "/";
        setTextInSourceWindow();
    }

    public void add_Multiply(View v) {
        if(LocalEdit.length() >= 1){
            if(LocalEdit.charAt(LocalEdit.length() - 1) == '*'){
                return;
            }
        }
        LocalEdit += "*";
        setTextInSourceWindow();
    }

    public void add_backBracket(View v) {
        LocalEdit += ")";
        setTextInSourceWindow();
    }

    public void add_frontBracket(View v) {
        LocalEdit += "(";
        setTextInSourceWindow();
    }

    public void add_Dat(View v) {
        if(LocalEdit.length() >= 1){
            if(LocalEdit.charAt(LocalEdit.length() - 1) == '.'){
                return;
            }
        }
        LocalEdit += ".";
        setTextInSourceWindow();
    }

    public void add_Remove(View v) {
        LocalEdit = SourceEdit.getText().toString();
        if (LocalEdit.length() == 0) return;

        int last_symb = LocalEdit.length() - 1;
        LocalEdit = LocalEdit.substring(0, last_symb);
        setTextInSourceWindow();
    }

    public void add_Clear(View v) {
        LocalEdit = "";
        setTextInSourceWindow();
    }

}
