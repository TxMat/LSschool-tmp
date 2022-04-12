package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CultureGeneraleActivity extends AppCompatActivity {

    RadioGroup radioGroup = findViewById(R.id.radioGroup);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_generale);
    }
}