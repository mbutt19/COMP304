package com.example.group3_comp304sec002_lab4;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class ClassroomRepository {
    private final ClassroomDao classroomDao;
    private final MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private final LiveData<List<Classroom>> classroomList;

    public ClassroomRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        classroomDao = db.classroomDao();
        //call interface method
        classroomList = classroomDao.getAllClassrooms();
    }

    LiveData<List<Classroom>> getSelectClassroom(int classroomId) { return classroomList; }
    LiveData<List<Classroom>> getAllClassrooms() { return classroomList; }
    LiveData<List<Classroom>> getClassStudentsFromStudent(int classroomId) { return classroomList; }
    LiveData<List<Classroom>> getClassFromStudent(int studentId) { return classroomList; }
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

