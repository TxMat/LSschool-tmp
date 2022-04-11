package com.example.berneteprojetandroid.bdd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ComptesDAO {

    @Query("SELECT * FROM utilisateur")
    List<Comptes> getAll();

    @Update
    void update(Comptes user);

    @Delete
    void delete(Comptes user);

    @Insert
    long insert(Comptes user);



}
