package com.example.group3_comp304sec002_lab4;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class ProfessorRepository {
    private final ProfessorDao professorDao;
    private final MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private final LiveData<List<Professor>> professorList;

    public ProfessorRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        professorDao = db.professorDao();
        //call interface method
        professorList = professorDao.getProfessors();
    }

    LiveData<List<Professor>> findProfessor(int professorId) { return professorList; }
    LiveData<List<Professor>> getProfessors(int professorId) { return professorList; }
    void insertProfessor(Professor professor) { insertAsync(professor); }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Professor professor){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    professorDao.insertProfessor(professor);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
