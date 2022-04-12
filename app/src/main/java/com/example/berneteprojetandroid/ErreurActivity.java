package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {

    public static final String NBERR_KEY = "nbErr_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);

        String err = getIntent().getStringExtra(NBERR_KEY);
        TextView nb = findViewById(R.id.table_nbErr);
        nb.setText("Tu as " + err + " erreurs, recommence !");
    }

    public void tableRecommencer(View view) {
        super.finish();
    }

    public void tableChanger(View view) {
        Intent intent = new Intent(this, ChoixTableActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}