package com.example.group3_comp304sec002_lab4;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ClassroomViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    ClassroomRepository classroomRepo;
    LiveData<Integer> insertResult;
    LiveData<List<Student>> allStudents;

    public ClassroomViewModel(@NonNull Application application) {
        super(application);
        classroomRepo = new ClassroomRepository(application);
        insertResult = classroomRepo.getInsertResult();
        seedData();
    }

    LiveData<List<Classroom>> getSelectClassroom(int classroomId) { return classroomRepo.getSelectClassroom(classroomId); }
    LiveData<List<Integer>> getClassStudentsFromStudent(int classroomId) { return classroomRepo.getClassStudentsFromStudent(classroomId); }
    LiveData<List<Classroom>> getClassFromStudent(int studentId) { return classroomRepo.getClassFromStudent(studentId); }
    void insertClassroom(Classroom... classrooms) { classroomRepo.insertClassroom(classrooms); }
    void updateClassroom(Classroom... classrooms) { classroomRepo.updateClassroom(classrooms);}
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void seedData(){
        Classroom c1 = new Classroom(001,2001,2,true,
                "White", 777);
        Classroom c2 = new Classroom(002,2002,1,false,
                "Yellow", 666);
        classroomRepo.insertClassroom(c1);
        classroomRepo.insertClassroom(c2);
    }
}