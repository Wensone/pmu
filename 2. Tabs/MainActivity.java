package com.example.u7er.tabs;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_tab1);

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(
                mTabHost.newTabSpec("one").setIndicator("Tab 1").setContent(
                        new Intent(this,
                        OneActivity.class)));

        mTabHost.addTab(
                mTabHost.newTabSpec("two").setIndicator("Tab 2").setContent(
                        new Intent(this,
                        TwoActivity.class )));
        mTabHost.addTab(
                mTabHost.newTabSpec("three").setIndicator("Tab 3").setContent(
                        new Intent(this,
                                ThreeActivity.class )));



        mTabHost.setCurrentTab(0);
    }
}
