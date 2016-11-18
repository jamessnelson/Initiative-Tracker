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

    private void save(List<Initiative> initList) {
        EditText charName = (EditText) findViewById(R.id.character_name);
        String name = charName.getText().toString();
        EditText initRoll = (EditText) findViewById(R.id.initiative_roll);
        int roll = Integer.parseInt(initRoll.getText().toString());

        // Create new Initiative object
        Initiative initiative = new Initiative();
        initiative.setName(name);
        initiative.setRoll(roll);

        //Parcel up init and put it in intent
        Intent data = new Intent();
        data.putExtra("initiative", initiative);
        // Activity finished return ok, return the data
        setResult(RESULT_OK, data);
        finish();
    }
}
