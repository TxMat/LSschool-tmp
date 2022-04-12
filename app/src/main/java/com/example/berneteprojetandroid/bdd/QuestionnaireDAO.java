package com.example.berneteprojetandroid.bdd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionnaireDAO {

    @Query("SELECT * FROM questionnaire")
    List<Questionnaire> getAll();

    @Query("SELECT * FROM questionnaire WHERE id = :id")
    Questionnaire getQs(long id);

    @Insert
    void insert(Questionnaire qs);

}