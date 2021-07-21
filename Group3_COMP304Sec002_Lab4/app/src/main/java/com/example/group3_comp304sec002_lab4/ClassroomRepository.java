package com.example.group3_comp304sec002_lab4;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class ClassroomRepository {
    private final ClassroomDao classroomDao;
    private final MutableLiveData<Integer> insertResult = new MutableLiveData<>();

    public ClassroomRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        classroomDao = db.classroomDao();
    }

    LiveData<List<Classroom>> getSelectClassroom(int classroomId) { return classroomDao.getSelectClassroom(classroomId); }
    LiveData<List<Integer>> getClassStudentsFromStudent(int classroomId) { return classroomDao.getClassStudentsFromStudent(classroomId); }
    LiveData<List<Classroom>> getClassFromStudent(int studentId) { return classroomDao.getClassFromStudent(studentId); }
    void insertClassroom(Classroom... classrooms) { insertAsync(classrooms); }
    void updateClassroom(Classroom... classrooms) { updateAsync(classrooms);}
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Classroom... classrooms){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.insertClassroom(classrooms);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateAsync(final Classroom... classrooms){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    classroomDao.updateClassroom(classrooms);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}

