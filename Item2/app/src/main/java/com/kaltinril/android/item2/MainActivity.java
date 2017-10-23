package com.kaltinril.android.item2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kaltinril.android.item2.flashcards.BasicFlashcard;
import com.kaltinril.android.item2.flashcards.MemoryFlashCard;

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

    public static int generateTheme(){

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

    public void unit17Click(View view){
        Intent intent = new Intent(this, Unit17Overview.class);
        startActivity(intent);
    }

    public void fc1Click(View view){
        Intent intent = new Intent(this, BasicFlashcard.class);
        startActivity(intent);
    }

    public void fc2Click(View view){
        Intent intent = new Intent(this, MemoryFlashCard.class);
        startActivity(intent);
    }
}
