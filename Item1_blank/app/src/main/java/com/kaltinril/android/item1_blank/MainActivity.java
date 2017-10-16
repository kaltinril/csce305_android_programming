package com.kaltinril.android.item1_blank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void topic1Click(View view){
        Intent intent = new Intent(this, Topic1.class);
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

    public void topic3Click(View view){
        Intent intent = new Intent(this, Topic3.class);
        startActivity(intent);
    }
}
