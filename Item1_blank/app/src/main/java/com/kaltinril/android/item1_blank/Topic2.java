package com.kaltinril.android.item1_blank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Topic2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic2);

    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void deadEndingsClick(View view){
        Intent i = new Intent(this, Topic2DeadEndings.class);
        startActivity(i);
    }
}
