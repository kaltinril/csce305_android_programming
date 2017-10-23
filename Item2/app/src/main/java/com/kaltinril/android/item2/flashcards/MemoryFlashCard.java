package com.kaltinril.android.item2.flashcards;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.kaltinril.android.item2.MainActivity;
import com.kaltinril.android.item2.R;
import com.kaltinril.android.item2.Topic1SilentSymbolExample;

import java.util.Random;

public class MemoryFlashCard extends AppCompatActivity {
    String[] thai_words;
    String[] english_words; // These are put into the board as 500 + the index to distinguish

    int totalItems;
    int totalRows;
    int totalCols;

    int[][] board;
    Random random;

    TableLayout grid;

    int totalDisplayed = 0;
    TextView[] displayed;

    // TODO: Implement a "game over" feature

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_memory_flash_card);

        // Get access to the grid
        grid = (TableLayout)findViewById(R.id.fc2_tableLayout);

        // Load the words
        Resources res = getResources();
        thai_words = res.getStringArray(R.array.topic2_examples_array_thai);
        english_words = res.getStringArray(R.array.topic2_examples_array_english_one_word);

        // Calculate limits
        totalItems = thai_words.length + english_words.length;
        totalCols = 3;
        totalRows = (int)Math.ceil(totalItems / (double)totalCols); // 3 items per row

        displayed = new TextView[2];

        // Setup the random
        random = new Random();

        // Generate and populate the board
        generateBoard();
        generateLayout();
    }

    // Need to add the textviews to the board with [$$$] to symbolize it is the back
    private void generateLayout(){

        int index = -1;
        String cardText = "";

        for(int row = 0; row < totalRows; row++) {
            // Create a new row
            TableRow tr =  new TableRow(this);

            // Create the columns
            for (int col=0;col<totalCols;col++) {
                index = board[col][row];

                if (index != -1){
                    if (index < 500)
                        cardText = thai_words[index];
                    else
                        cardText = english_words[index - 500]; // We used this to be able to distinguish between them in the 2d array

                    // Create a new column at this row and with the text
                    TextView textview = new TextView(this);
                    textview.setTag(R.string.memory_index, index);
                    textview.setTag(R.string.memory_text, cardText);
                    textview.setText("[$$$]");
                    textview.setGravity(Gravity.CENTER);
                    textview.setTextSize(20);

                    textview.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (totalDisplayed < 2) {
                                TextView tv = (TextView)v;
                                String currentText = tv.getText().toString();

                                if (currentText.equals("[$$$]")) {

                                    tv.setText((String) tv.getTag(R.string.memory_text));
                                    displayed[totalDisplayed] = tv;
                                    totalDisplayed++;

                                    // Check if they were correct
                                    if (totalDisplayed == 2) {

                                        int first = ((int) displayed[0].getTag(R.string.memory_index)) % 500;
                                        int second = ((int) displayed[1].getTag(R.string.memory_index)) % 500;

                                        if (first == second) {
                                            // Clear the displayed cards
                                            displayed[0] = null;
                                            displayed[1] = null;

                                            Toast.makeText(MemoryFlashCard.this, "Match!", Toast.LENGTH_SHORT).show();
                                            totalDisplayed = 0;
                                        }
                                    }
                                }
                            }
                            else
                            {
                                // TODO: Make this a timed thing where it hides after 2 seconds, instead of needing to click again
                                Toast.makeText(MemoryFlashCard.this, "Incorrect... try again!", Toast.LENGTH_SHORT).show();

                                // Hide the cards and reset the total displayed
                                displayed[0].setText("[$$$]");
                                displayed[1].setText("[$$$]");

                                totalDisplayed = 0;
                            }


                        }
                    });


                    // Add the column to the row
                    tr.addView(textview);
                }
            }
            // Add the row to the Layout
            grid.addView(tr);
        }
    }

    private void generateBoard(){
        // Generate board
        board = new int[totalCols][totalRows];

        clearBoard();

        // loop over the thai words
        for(int index=0; index<thai_words.length; index++){
            placeWord(index);
            placeWord(index + 500);
            System.out.println(index);
        }
    }

    private void placeWord(int index){
        // pick a number between 0-3 for column
        int col = random.nextInt(totalCols);
        int row = random.nextInt(totalRows);

        // Yeah, the spot was empty!
        if (board[col][row] == -1) {
            board[col][row] = index;
            return;
        } else {

            // Find the next empty spot and shove it there
            for(col=0;col<totalCols;col++) {
                for (row = 0; row < totalRows; row++) {
                    if (board[col][row] == -1) {
                        board[col][row] = index;
                        return;
                    }
                }
            }
        }
    }

    private void clearBoard(){
        for(int col=0;col<totalCols;col++){
            for(int row=0;row<totalRows;row++){
                board[col][row] = -1;
            }
        }
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
