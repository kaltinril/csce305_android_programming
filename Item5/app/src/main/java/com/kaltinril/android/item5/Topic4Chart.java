package com.kaltinril.android.item5;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Topic4Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic4_chart);

        TableLayout chart = (TableLayout)findViewById(R.id.topic4_chart_tl);

        // Load the items list
        Resources res = getResources();
        String[] chart_items = res.getStringArray(R.array.topic4_chart);

        boolean header = true;
        boolean greenPaper = false;

        // Loop over the items adding them to the table
        for (String row : chart_items){
            // Create a TableRow
            TableRow tr =  new TableRow(this);
            tr.setGravity(Gravity.CENTER);

            // split row into columns
            String[] columns = row.split("\\|{2}");

            // loop over the columns creating a TextView and adding it to the TableRow
            for (String column : columns){
                // Create the TextView for each column
                TextView textview = new TextView(this);
                textview.setText(column);
                textview.setGravity(Gravity.CENTER);


                if (header) {
                    textview.setBackgroundColor(Color.GRAY);
                    textview.setTextSize(18);
                }
                else
                    textview.setTextSize(20);

                if (!header && greenPaper)
                    textview.setBackgroundColor(Color.LTGRAY);

                // Add the the TextView to the row
                tr.addView(textview);
            }

            // Alternatve the rows with light grey by flipping this
            if (!header)
                greenPaper = !greenPaper;

            // After the first row, this is no longer ther header row
            header = false;

            // add the row to the Table
            chart.addView(tr);
        }

    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
