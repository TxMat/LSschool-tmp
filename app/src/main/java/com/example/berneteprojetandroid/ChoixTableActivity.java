package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

public class ChoixTableActivity extends AppCompatActivity {

    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choix_table);

        np = findViewById(R.id.numberPicker);

        np.setMinValue(1);
        np.setMaxValue(9);


    }

    public void choixTableValider(View view) {
        int table = np.getValue();
        Toast.makeText(this, "Table choisie : "+table, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.putExtra(TableMultiplicationActivity.TABLE_KEY, table);
        startActivity(intent);
    }
}