package com.kaltinril.android.item2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Unit17Overview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_unit17_overview);
    }

    public void topic1Click(View view){
        Intent intent = new Intent(this, Topic1.class);
        startActivity(intent);
    }

    public void topic1SilentSymbolClick(View view){
        Intent intent = new Intent(this, Topic1SilentSymbolExample.class);
        startActivity(intent);
    }

    public void topic2Click(View view){
        Intent intent = new Intent(this, Topic2.class);
        startActivity(intent);
    }

    public void deadEndingsClick(View view){
        Intent i = new Intent(this, Topic2DeadEndings.class);
        startActivity(i);
    }

    public void liveEndingsClick(View view){
        Intent i = new Intent(this, Topic2LiveEndings.class);
        startActivity(i);
    }

    public void exampleClick(View view){
        Intent intent = new Intent(this, Topic2Examples.class);
        startActivity(intent);
    }

    public void topic3Click(View view){
        Intent intent = new Intent(this, Topic3.class);
        startActivity(intent);
    }

    public void topic4Click(View view){
        Intent intent = new Intent(this, Topic4.class);
        startActivity(intent);
    }

    public void topic4ChartClick(View view){
        Intent intent = new Intent(this, Topic4Chart.class);
        startActivity(intent);
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
