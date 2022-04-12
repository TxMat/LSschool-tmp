package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.berneteprojetandroid.mathematiquesData.Additions;

public class AdditionsActivity extends AppCompatActivity {

    int nb_op = 0;
    int nbJuste;
    Additions addition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additions);

        Button valider = findViewById(R.id.addition_valider);
        EditText reponseView = findViewById(R.id.reponseAddition);

        addition();

        valider.setOnClickListener (view -> {

            if (reponseView.getText().toString().equals("")) {
                   addition.setCalcul(-1);
                } else {
                    addition.setCalcul(Integer.valueOf(reponseView.getText().toString()));
                    reponseView.setText("");
                }

            if (addition.getCalcul() != -1){
                if (addition.resultatJuste()) {
                    nbJuste++;
                }
                if (nb_op != 10) {
                    addition();
                } else {
                    Intent ResultatAdditionIntent = new Intent(this, ResultatAdditionsActivity.class);
                    ResultatAdditionIntent.putExtra(ResultatAdditionsActivity.NBJUSTE_KEY, String.valueOf(nbJuste));
                    startActivity(ResultatAdditionIntent);
                }

            } else {
                Toast.makeText(this,"Entrez un résultat", Toast.LENGTH_SHORT).show();
            }


        });
    }

    public void addition() {
        nb_op++;
        TextView num = findViewById(R.id.numAddition);
        num.setText("["+nb_op+"/10]");
        addition = new Additions();
        TextView operation = findViewById(R.id.texteAddition);
        operation.setText(addition.getOperande1() + " + " + addition.getOperande2() + " = ");


    }


}