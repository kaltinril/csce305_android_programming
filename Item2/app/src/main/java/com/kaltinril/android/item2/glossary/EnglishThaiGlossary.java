package com.kaltinril.android.item2.glossary;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.kaltinril.android.item2.MainActivity;
import com.kaltinril.android.item2.R;

import java.util.Arrays;
import android.widget.AdapterView.OnItemSelectedListener;

public class EnglishThaiGlossary extends AppCompatActivity implements OnItemSelectedListener{

    ArrayAdapter<String> adapter;
    String[] glossary_combined;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_english_thai_glossary);

        // Load the string array
        Resources res = getResources();
        glossary_combined = res.getStringArray(R.array.glossary_sublist);

        // Sory the string array
        Arrays.sort(glossary_combined, String.CASE_INSENSITIVE_ORDER);

        adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, glossary_combined);
        Spinner spinner = (Spinner)findViewById(R.id.gloss2_spinner);
        spinner.setAdapter(adapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        ListView listview = (ListView)findViewById(R.id.gloss2_listview);
        listview.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        String[] items = new String[1];
        items[0] = item;

        adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);

        ListView listview = (ListView)findViewById(R.id.gloss2_listview);
        listview.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, glossary_combined);

        ListView listview = (ListView)findViewById(R.id.gloss2_listview);
        listview.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
