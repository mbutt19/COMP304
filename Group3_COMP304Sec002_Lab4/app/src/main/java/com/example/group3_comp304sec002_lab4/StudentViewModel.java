package com.example.group3_comp304sec002_lab4;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    StudentRepository studentRepository;
    LiveData<Integer> insertResult;
    LiveData<List<Student>> allStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        insertResult = studentRepository.getInsertResult();
        allStudents = studentRepository.getAllStudents();
        seedData();
    }

    LiveData<List<Student>> getAllStudents() { return allStudents; }
    LiveData<List<Student>> getSelectStudent(int studentId) { return studentRepository.getSelectStudent(studentId); }
    LiveData<List<Student>> getAllStudentsInClass(int classroomId) { return studentRepository.getAllStudentsInClass(classroomId); }
    void insertStudent(Student... students) { studentRepository.insertStudent(students); }
    void updateStudent(Student student) { studentRepository.updateStudent(student);}
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    public void seedData(){
        Student s1 = new Student(666,"Bart","Simpson","Art",
                001, 2001);
        Student s2 = new Student(777,"Charlie","Brown","Philosophy",
                003, 2002);
        studentRepository.insertStudent(s1);
        studentRepository.insertStudent(s2);
    }
}
