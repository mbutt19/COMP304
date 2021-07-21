package com.example.group3_comp304sec002_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfessorDao {

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Professor where professorId = :professorId")
    LiveData<List<Professor>> findProfessor(int professorId);
    @Query("select * from Professor order by professorId")
    LiveData<List<Professor>> getProfessors();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProfessor(Professor professor);
}