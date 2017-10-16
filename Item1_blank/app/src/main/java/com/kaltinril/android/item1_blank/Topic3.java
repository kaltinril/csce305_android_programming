package com.kaltinril.android.item1_blank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Topic3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic3);
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // remove all other activites from the stack
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void topic4Click(View view){
        Intent i = new Intent(this, Topic4.class);
        startActivity(i);

        // Needed a way to change between topics so that the back button would go back to the main list of topics
        finish(); // Causes Topic3 to be destroyed and removed from the Activity stack after calling startActivity.
    }
}
