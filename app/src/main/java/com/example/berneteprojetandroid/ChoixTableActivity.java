package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class ChoixTableActivity extends AppCompatActivity {

    public final static int TABLE_REQUEST = 0;
    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix_table);

        np = findViewById(R.id.numberPicker);

        np.setMinValue(1);
        np.setMaxValue(9);

        //np.setOnValueChangedListener(onValueChangeListener);
    }

    /*NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int i, int i1) {
            Toast.makeText(Exercice5Activity.this,
                    "Table choisie : "+numberPicker.getValue(), Toast.LENGTH_SHORT);
        }
    };*/

    public void exercice5Valider(View view) {
        int table = np.getValue();
        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.putExtra(TableMultiplicationActivity.TABLE_KEY, table);
        //startActivityForResult(intent, TABLE_REQUEST);
        startActivity(intent);
    }
}