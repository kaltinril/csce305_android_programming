package com.kaltinril.android.item2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = generateTheme();
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int generateTheme(){

        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(Calendar.DAY_OF_WEEK);

        int theme = R.style.AppTheme_Sunday;

        switch(day){
            case Calendar.SUNDAY:
                theme = R.style.AppTheme_Sunday;
                break;
            case Calendar.MONDAY:
                theme = R.style.AppTheme_Monday;
                break;
            case Calendar.TUESDAY:
                theme = R.style.AppTheme_Tuesday;
                break;
            case Calendar.WEDNESDAY:
                theme = R.style.AppTheme_Wednesday;
                break;
            case Calendar.THURSDAY:
                theme = R.style.AppTheme_Thursday;
                break;
            case Calendar.FRIDAY:
                theme = R.style.AppTheme_Friday;
                break;
            case Calendar.SATURDAY:
                theme = R.style.AppTheme_Saturday;
                break;
        }

        return theme;
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
}
