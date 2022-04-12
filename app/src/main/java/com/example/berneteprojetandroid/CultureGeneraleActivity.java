package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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

    RadioGroup radioGroup = findViewById(R.id.radioGroup);

    ArrayList<Questionnaire> listeQuestions;
    int nb_quest = 0;
    int nbJuste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_generale);

        valider.setOnClickListener (view -> {
            if (radioGroup.getCheckedRadioButtonId() == id_juste) {
                nbJuste++;
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

    public void question() {
        TextView questionText = findViewById(R.id.question);
        ArrayList<Integer> aLreponse = new ArrayList<>(Arrays.asList(1,2,3,4));

        int indiceQuestion = (int)(Math.random() * ((listeQuestions.size() - 0) + 1)) + 0;
        Questionnaire question = listeQuestions.get(indiceQuestion);
        questionText.setText(question.getQuestion());
        String[] reponses = question.getReponses_possibles();
        for (int i = 0; i < 4; i++) {
            int placeRep = (int)(Math.random() * (((aLreponse.size()-1) - 0) + 1)) + 0;
            switch (aLreponse.get(placeRep)){
                case 1:
                    RadioButton bouton1 = findViewById(R.id.bouton1);
                    bouton1.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i] == question.getBonne_reponse()) {
                        int id_juste = R.id.bouton1;
                    }
                    break;
                case 2:
                    RadioButton bouton2 = findViewById(R.id.bouton2);
                    bouton2.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i] == question.getBonne_reponse()) {
                        int id_juste = R.id.bouton2;
                    }
                    break;
                case 3:
                    RadioButton bouton3 = findViewById(R.id.bouton3);
                    bouton3.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i] == question.getBonne_reponse()) {
                        int id_juste = R.id.bouton3;
                    }
                    break;
                case 4:
                    RadioButton bouton4 = findViewById(R.id.bouton4);
                    bouton4.setText(reponses[i]);
                    aLreponse.remove(placeRep);
                    if (reponses[i] == question.getBonne_reponse()) {
                        int id_juste = R.id.bouton4;
                    }
                    break;
            }
        }
        nb_quest++;
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

                // le code pour quand question list est ok va la

                //int questionnb = getIntent().getIntExtra("numberOfQuestions", 10);
                //quizModel = new QuizModel(questionnb, questionList);
                //initialize();
            }
        }

        GetQuestions getQ = new GetQuestions();
        getQ.execute();
    }
}