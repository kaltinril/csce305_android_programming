package com.kaltinril.android.item5;

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
