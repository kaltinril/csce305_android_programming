package com.kaltinril.android.item1_blank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Topic1SilentSymbolExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silent_symbol_example);
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void topic2Click(View view){
        Intent i = new Intent(this, Topic2.class);
        startActivity(i);

        // Needed a way to change between topics so that the back button would go back to the main list of topics
        // works if we are on the main topic but not if we are a few layers down
        finish(); // Causes this to be destroyed and removed from the Activity stack after calling startActivity.
    }
}
