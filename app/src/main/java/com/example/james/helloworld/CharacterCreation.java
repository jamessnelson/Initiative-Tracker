package com.example.james.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class CharacterCreation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainMenu.EXTRA_MESSAGE);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(name);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_character_creation);
        layout.addView(textView);
    }

    private List<Initiative> save(List<Initiative> initList) {
        EditText charName = (EditText) findViewById(R.id.character_name);
        String name = charName.getText().toString();
        EditText initRoll = (EditText) findViewById(R.id.initiative_roll);
        int roll = Integer.parseInt(initRoll.getText().toString());

        // Create new Initiative object
        Initiative initiative = new Initiative();
        initiative.setName(name);
        initiative.setRoll(roll);

        // Add it to public list
        initList.add(initiative);

        return initList;
    }
}
