package com.example.group3_comp304sec002_lab4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProfessorViewModel extends AndroidViewModel {
    ProfessorRepository professorRepo;
    LiveData<Integer> insertResult;

    public ProfessorViewModel(@NonNull Application application) {
        super(application);
        professorRepo = new ProfessorRepository(application);
        insertResult = professorRepo.getInsertResult();
        seedData();
    }

    LiveData<List<Professor>> findProfessor(int professorId) { return professorRepo.findProfessor(professorId); }
    LiveData<List<Professor>> getProfessors() { return professorRepo.getProfessors(); }
    void insertProfessor(Professor professor) { professorRepo.insertProfessor(professor); }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void seedData(){
        Professor p1 = new Professor(2001,"Bill","Murray","Art","password");
        Professor p2 = new Professor(2002,"Ted","Nugent","Music","stallion");
        professorRepo.insertProfessor(p1);
        professorRepo.insertProfessor(p2);
    }
}
