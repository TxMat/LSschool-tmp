package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.berneteprojetandroid.mathematiquesData.Multiplication;
import com.example.berneteprojetandroid.mathematiquesData.TableDeMultiplication;

import java.util.ArrayList;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static final String TABLE_KEY = "table_key";
    public final static int FEL_REQUEST = 1;
    public final static int ERR_REQUEST = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        int table;
        ArrayList<EditText> reponses;
        TableDeMultiplication tableMultiplication;
        LinearLayout linear;
        Button valider = findViewById(R.id.exercice5_valider);

        table = getIntent().getIntExtra(TABLE_KEY,1);
        //Générer la table
        reponses = new ArrayList<>();
        linear = findViewById(R.id.operation_multiplication);

        tableMultiplication = new TableDeMultiplication(table);

        for (Multiplication multiplication : tableMultiplication.getMultiplications()) {
            //Ligne tempo
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.operation_multiplication, null);

            //Texte de l'opération
            TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = ");

            //EditText
            EditText resultat = linearTMP.findViewById(R.id.template_resultat);
            reponses.add(resultat);

            //Ajout au layout principal

            linear.addView(linearTMP);
        }

        valider.setOnClickListener (view -> {
            int i = 0;
            for (EditText reponseText : reponses) {
                int reponse;
                if (reponseText.getText().toString().equals("")) {
                    reponse = 0;
                } else {
                    reponse = Integer.valueOf(reponseText.getText().toString());
                }
                tableMultiplication.getMultiplicationIndice(i).setCalcul(reponse);
                i++;
            }

            Intent intent;
            int juste = tableMultiplication.nbReponsesJustes();
            if (juste == 10) {
                intent = new Intent(this, FelicitationActivity.class);
                startActivity(intent);
            } else {
                int nb_erreurs = 10 - juste;
                intent = new Intent(this, ErreurActivity.class);
                intent.putExtra(ErreurActivity.NBERR_KEY, String.valueOf(nb_erreurs));
                startActivity(intent);
            }
        });












    }
}