package com.example.group3_comp304sec002_lab4;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;

public class StudentRepository {
    private final StudentDao studentDao;
    private final MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private final LiveData<List<Student>> studentList;

    public StudentRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getInstance(context);
        //create an interface object
        studentDao = db.studentDao();
        //call interface method
        studentList = studentDao.getAllStudents();
    }

    LiveData<List<Student>> getAllStudents() { return studentList; }
    LiveData<List<Student>> getSelectStudent(int studentId) { return studentList; }
    LiveData<List<Student>> getAllStudentsInClass(int classroomId) { return studentList; }
    void insertStudent(Student... students) { insertAsync(students); }
    void updateStudent(Student student) { updateAsync(student);}
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Student... students){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.insertStudent(students);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void updateAsync(final Student student){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    studentDao.updateStudent(student);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
