package com.kaltinril.android.item2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Topic4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_topic4);
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, Unit17Overview.class);
        startActivity(i);
        finish();
    }

    public void chartsClick(View view){
        Intent i = new Intent(this, Topic4Chart.class);
        startActivity(i);
        finish();
    }
}
