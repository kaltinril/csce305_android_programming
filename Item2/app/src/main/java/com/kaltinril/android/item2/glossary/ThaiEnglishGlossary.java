package com.kaltinril.android.item2.glossary;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.kaltinril.android.item2.MainActivity;
import com.kaltinril.android.item2.R;
import com.kaltinril.android.item2.Unit17Overview;

import java.util.Arrays;

public class ThaiEnglishGlossary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick the theme based on the day of the week so we always use the "lucky" color for thai
        int theme = MainActivity.generateTheme();
        setTheme(theme);

        setContentView(R.layout.activity_thai_english_glossary);

        // Load the string array
        Resources res = getResources();
        String[] glossary_combined = res.getStringArray(R.array.glossary_thai_eng_combined);

        // Sory the string array
        Arrays.sort(glossary_combined, String.CASE_INSENSITIVE_ORDER);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, glossary_combined);
        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.gloss1_ac_tv);
        textView.setAdapter(adapter);

        ListView listview = (ListView)findViewById(R.id.gloss1_listview);
        listview.setAdapter(adapter);
    }

    public void overviewClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        // set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
