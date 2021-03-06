package com.kaltinril.android.item2.flashcards;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.kaltinril.android.item2.MainActivity;
import com.kaltinril.android.item2.R;

public class BasicFlashcard extends AppCompatActivity {

    String[] thai_words;
    String[] english_words;
    String[] sound_names;
    String[] image_names;

    int currentCard = 0;
    int maxCards = 0;
    boolean flipped = false;
    boolean stayFlipped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_basic_flashcard);

        Resources res = getResources();
        thai_words = res.getStringArray(R.array.topic2_examples_array_thai);
        english_words = res.getStringArray(R.array.topic2_examples_array_english);
        sound_names = res.getStringArray(R.array.topic2_examples_array_sounds);
        image_names = res.getStringArray(R.array.topic2_examples_array_sounds);

        // Dynamically based on the maximum number of images
        maxCards = image_names.length;

        setupCard();
    }

    private void setupCard(){
        // Disable the image so it is not visible
        ImageView img = (ImageView)findViewById(R.id.fc1_img);
        if (!stayFlipped)
            img.setVisibility(View.INVISIBLE);

        // update the image to the appropriate one for this card
        int image_identifier = getResources().getIdentifier(image_names[currentCard], "drawable", getPackageName());
        img.setImageResource(image_identifier);

        // Disable the english text so it is invisible
        TextView textview = (TextView)findViewById(R.id.fc1_eng);
        if (!stayFlipped)
            textview.setVisibility(View.INVISIBLE);

        // Change the english text
        textview.setText(english_words[currentCard]);

        // Change the Thai Text
        TextView thaiText = (TextView)findViewById(R.id.fc1_thai);
        thaiText.setText(thai_words[currentCard]);

        // On first display of the card, it is "not" flipped
        if (!stayFlipped)
            flipped = false;
    }

    private void flipCard(){
        if (flipped)
            hideFlipped();
        else
            showFlipped();

        // Flip the flipped flipping flip variable
        if (!stayFlipped)
            flipped=!flipped;
    }

    private void showFlipped(){
        // english and image are not visibvle, display them
        ImageView img = (ImageView)findViewById(R.id.fc1_img);
        TextView textview = (TextView)findViewById(R.id.fc1_eng);

        img.setVisibility(View.VISIBLE);
        textview.setVisibility(View.VISIBLE);
    }

    private void hideFlipped(){
        // It was flipped, hide the other parts now
        ImageView img = (ImageView)findViewById(R.id.fc1_img);
        TextView textview = (TextView)findViewById(R.id.fc1_eng);

        img.setVisibility(View.INVISIBLE);
        textview.setVisibility(View.INVISIBLE);
    }

    private void nextCard(){
        // Loop through cards and back to begining
        currentCard++;
        if (currentCard >= maxCards)
            currentCard = 0;

        setupCard();
    }

    public void fc1FlipClick(View view){
        if (stayFlipped)
            flipped = true;

        flipCard();
    }

    public void fc1NextClick(View view){
        if (stayFlipped)
            flipped = true;

        nextCard();
    }

    public void fc1SwitchCLick(View view){
        Switch sw = (Switch)view;
        stayFlipped = sw.isChecked();

        // Disable or Enable the flip button
        Button btn = (Button)findViewById(R.id.fc1_flip);
        btn.setEnabled(!stayFlipped);

        if (stayFlipped) {
            flipped = true;
            showFlipped();
        }
        else {
            flipped = false;
            hideFlipped();
        }
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
