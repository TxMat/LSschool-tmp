package com.example.berneteprojetandroid.bdd;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.berneteprojetandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@Database(entities = {Comptes.class, Questionnaire.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class BD extends RoomDatabase {

    public abstract ComptesDAO cdDao();

    private static final RoomDatabase.Callback clbck = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase bd){
            super.onCreate(bd);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static BD INSTANCE;

    public static Context context;

    public static synchronized BD getInstance(Context context) {

        BD.context = context;

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    BD.class, "LSDb")
                    .addCallback(clbck)
                    .build();
        }
        return INSTANCE;
    }

    private static void fillWithStartingData(Context context) {
        QuestionnaireDAO QuestDAO = getInstance(context).questDao();
        JSONArray jsonArray = loadJSONArray(context);

        try {
            for (int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String question = jsonObject.getString("question");
                String answer = jsonObject.getString("réponse");
                //remove " and [ and ] from the string
                String prop = jsonObject.getString("propositions")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("\"", "");
                String[] choices = prop.split(",");

                Questionnaire qs = new Questionnaire();
                qs.setQuestion(question);
                qs.setBonne_reponse(answer);
                qs.setReponses_possibles(choices);

                QuestDAO.insert(qs);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // load data from raw/questionsData.json to the database
    private static JSONArray loadJSONArray(Context context) {
        StringBuilder sb = new StringBuilder();
        InputStream is = context.getResources().openRawResource(R.raw.dbdata);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            return jsonObject.getJSONArray("culture");

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract QuestionnaireDAO questDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private PopulateDbAsyncTask(BD db) {
            QuestionnaireDAO quizDao = db.questDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            fillWithStartingData(context);
            return null;
        }

    }

}