package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.berneteprojetandroid.bdd.BD;
import com.example.berneteprojetandroid.bdd.Questionnaire;
import com.example.berneteprojetandroid.mathematiquesData.Additions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CultureGeneraleActivity extends AppCompatActivity {

    ArrayList<Questionnaire> listeQuestions;
    int nb_quest = 0;
    int nbJuste;
    int id_juste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getQuestions();
        setContentView(R.layout.activity_culture_generale);





    }

    public void question() {
        TextView questionText = findViewById(R.id.question);
        ArrayList<Integer> aLreponse = new ArrayList<>(Arrays.asList(1,2,3,4));
        id_juste = -1;

        int indiceQuestion = (int)(Math.random() * ((listeQuestions.size()-1 - 0) + 1)) + 0;
        Questionnaire question = listeQuestions.get(indiceQuestion);
        questionText.setText(question.getQuestion());
        String[] reponses = question.getReponses_possibles();
        String bonneReponse = question.getBonne_reponse();
        for (int i = 0; i < 4; i++) {
            int placeRep = (int)(Math.random() * (((aLreponse.size()-1) - 0) + 1)) + 0;
            switch (aLreponse.get(placeRep)){
                case 1:
                    RadioButton bouton1 = findViewById(R.id.bouton1);
                    bouton1.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i].equals(bonneReponse)) {
                        id_juste = R.id.bouton1;
                    }
                    break;
                case 2:
                    RadioButton bouton2 = findViewById(R.id.bouton2);
                    bouton2.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i].equals(bonneReponse)) {
                        id_juste = R.id.bouton2;
                    }
                    break;
                case 3:
                    RadioButton bouton3 = findViewById(R.id.bouton3);
                    bouton3.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i].equals(bonneReponse)) {
                        id_juste = R.id.bouton3;
                    }
                    break;
                case 4:
                    RadioButton bouton4 = findViewById(R.id.bouton4);
                    bouton4.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i].equals(bonneReponse)) {
                        id_juste = R.id.bouton4;
                    }
                    break;
            }
        }
        nb_quest++;
    }

    private void initListener(){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button valider = findViewById(R.id.cultGvalider);
        valider.setOnClickListener (view -> {

            if (radioGroup.getCheckedRadioButtonId() != -1){
                if (radioGroup.getCheckedRadioButtonId() == id_juste) {
                    nbJuste++;
                }
                if (nb_quest != 10) {
                    radioGroup.clearCheck();
                    question();
                } else {
                    Intent ResultatCulturegIntent = new Intent(this, ResultatCulturegActivity.class);
                    ResultatCulturegIntent.putExtra(ResultatCulturegActivity.NBJUSTE_KEY, String.valueOf(nbJuste));
                    startActivity(ResultatCulturegIntent);
                }

            } else {
                Toast.makeText(this,"Sélectionne une réponse !", Toast.LENGTH_SHORT).show();
            }
        });
        question();
    }

    private void getQuestions() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetQuestions extends AsyncTask<Void, Void, List<Questionnaire>> {

            @Override
            protected List<Questionnaire> doInBackground(Void... voids) {
                return BD.getInstance(getApplicationContext()).questDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Questionnaire> qz) {
                super.onPostExecute(qz);
                listeQuestions = (ArrayList<Questionnaire>) qz;
                initListener();
            }
        }

        GetQuestions getQ = new GetQuestions();
        getQ.execute();
    }
}