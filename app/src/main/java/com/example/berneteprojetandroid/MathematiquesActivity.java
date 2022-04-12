package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathematiquesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematiques);
    }

    public void onTableDeMultiplications(View view) {
        Intent ChoixTableActivityIntent = new Intent(this, ChoixTableActivity.class);
        startActivity(ChoixTableActivityIntent);
    }

    public void onAdditions(View view) {
        Intent AdditionsActivityIntent = new Intent(this, AdditionsActivity.class);
        startActivity(AdditionsActivityIntent);
    }
}