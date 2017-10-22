package com.kaltinril.android.item2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Topic2Examples extends AppCompatActivity {

    // Store these so that we don't have to re-load them all the time
    MediaPlayer mp;
    Button soundButtons[];
    String[] sound_names;       // Need these for the button to load the correct image
    Dialog imageDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic2_examples);

        Resources res = getResources();
        String[] thai_words = res.getStringArray(R.array.topic2_examples_array_thai);
        String[] english_words = res.getStringArray(R.array.topic2_examples_array_english);
        String[] ref_nums = res.getStringArray(R.array.topic2_examples_array_ref);
        sound_names = res.getStringArray(R.array.topic2_examples_array_sounds);

        // ASSUME (Dangerous!) that we have the same number of each item
        // Loop over eawch word adding i to an existing button
        // TODO: Create the button's dynamically instead of having them placed already
        TextView textview;
        for (int i=0;i<thai_words.length;i++){
            textview = (TextView)findViewById(getResources().getIdentifier("tb_t2example_thai" + (i + 1), "id", getPackageName()));
            textview.setText(thai_words[i]);
        }

        for (int i=0;i<english_words.length;i++){
            textview = (TextView)findViewById(getResources().getIdentifier("tb_t2example_eng" + (i + 1), "id", getPackageName()));
            textview.setText(english_words[i]);
        }

        for (int i=0;i<ref_nums.length;i++){
            textview = (TextView)findViewById(getResources().getIdentifier("tb_t2example_ref" + (i + 1), "id", getPackageName()));
            textview.setText(ref_nums[i]);
        }

        soundButtons = new Button[sound_names.length];

        for (int i=0;i<sound_names.length;i++){
            soundButtons[i] = (Button)findViewById(getResources().getIdentifier("tb_t2example_snd" + (i + 1), "id", getPackageName()));

            // Store the identifier name in the buttons tag
            int sound_identifier = getResources().getIdentifier(sound_names[i], "raw", getPackageName());
            soundButtons[i].setTag(sound_identifier);

            // Build a dynamic listener and attach it to the above button
            soundButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Reset the MediaPlayer object if it is not released.
                    if(mp!=null) {
                        mp.release();
                        mp=null;
                    }

                    // Setup the Mdeia Player so we can play the sound
                    mp = MediaPlayer.create(Topic2Examples.this, (int)v.getTag());

                    // Start the Media Player
                    mp.start();
                }
            });

        }

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

    public void topic3Click(View view){
        Intent i = new Intent(this, Topic3.class);
        startActivity(i);
        finish();
    }

    // These methods are a simple way to do this
    // Shoud look at adding an onClickListener instead that uses the TAG to pass it
    public void row1Click(View view){
        showDialog(sound_names[0]);
    }

    public void row2Click(View view){
        showDialog(sound_names[1]);
    }

    public void row3Click(View view){
        showDialog(sound_names[2]);
    }

    public void row4Click(View view){
        showDialog(sound_names[3]);
    }

    public void row5Click(View view){
        showDialog(sound_names[4]);
    }

    public void row6Click(View view){
        showDialog(sound_names[5]);
    }

    public void row7Click(View view){
        showDialog(sound_names[6]);
    }

    public void row8Click(View view){
        showDialog(sound_names[7]);
    }

    public void row9Click(View view){
        showDialog(sound_names[8]);
    }

    private void showDialog(String imageName){
        imageDialog = new Dialog(this);
        imageDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        imageDialog.setContentView(getLayoutInflater().inflate(R.layout.dialog_image_layout, null));

        // Change the image
        ImageView iv = (ImageView)imageDialog.findViewById(R.id.imageViewDialog);
        int image_identifier = getResources().getIdentifier(imageName, "drawable", getPackageName());
        iv.setImageResource(image_identifier);

        // Show the dialog
        imageDialog.show();
    }

    public void dismissListener(View view){
        imageDialog.dismiss();
    }

}
