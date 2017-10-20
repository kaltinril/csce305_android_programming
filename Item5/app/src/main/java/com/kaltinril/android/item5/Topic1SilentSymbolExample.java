package com.kaltinril.android.item5;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topic1SilentSymbolExample extends AppCompatActivity {

    // Store these so that we don't have to re-load them all the time
    MediaPlayer mp;
    Button silentButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silent_symbol_example);

        // Get access to the button
        silentButton = (Button)this.findViewById(R.id.Rec17_1);

        // Build a dynamic listener and attach it to the above button
        silentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Reset the MediaPlayer object if it is not released.
                if(mp!=null) {
                    mp.release();
                    mp=null;
                }

                // Setup the Mdeia Player so we can play the sound
                mp = MediaPlayer.create(Topic1SilentSymbolExample.this, R.raw.rec17_1);

                // Start the Media Player
                mp.start();
            }
        });

    }

    // Make sure we clean up the media player on destroy.
    @Override
    protected void onDestroy(){
        if (mp != null){
            mp.release();
            mp = null;
        }

        super.onDestroy();
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
