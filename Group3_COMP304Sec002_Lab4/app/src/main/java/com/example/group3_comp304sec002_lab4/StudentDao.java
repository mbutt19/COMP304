package com.example.group3_comp304sec002_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Student order by studentId")
    LiveData<List<Student>> getAllStudents();
    @Query("select * from Student where studentId = :studentId")
    LiveData<List<Student>> getSelectStudent(int studentId);
    @Query("select * from Student where classroom = :classroomId")
    LiveData<List<Student>> getAllStudentsInClass(int classroomId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student... students);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateStudent(Student student);
}
