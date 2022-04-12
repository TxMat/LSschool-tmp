package com.example.berneteprojetandroid.bdd;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "questionnaire")
public class Questionnaire {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String question;

    private String[] reponses_possibles;

    private String bonne_reponse;

    public String[] getReponses_possibles() {
        return reponses_possibles;
    }

    public void setReponses_possibles(String[] reponses_possibles) {
        this.reponses_possibles = reponses_possibles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBonne_reponse() {
        return bonne_reponse;
    }

    public void setBonne_reponse(String bonne_reponse) {
        this.bonne_reponse = bonne_reponse;
    }

}