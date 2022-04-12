package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.berneteprojetandroid.bdd.BD;
import com.example.berneteprojetandroid.bdd.Questionnaire;

import java.util.ArrayList;
import java.util.List;

public class CultureGeneraleActivity extends AppCompatActivity {

    RadioGroup radioGroup = findViewById(R.id.radioGroup);

    private ArrayList<Questionnaire> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culture_generale);
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
                // la var est pleine mtn
                questionList = (ArrayList<Questionnaire>) qz;

                // le code pour quand question list est ok va la

                //int questionnb = getIntent().getIntExtra("numberOfQuestions", 10);
                //quizModel = new QuizModel(questionnb, questionList);
                //initialize();
            }
        }

        GetQuestions gq = new GetQuestions();
        gq.execute();
    }
}