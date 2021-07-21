package com.example.group3_comp304sec002_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClassroomDao{
    //Monitoring Query Result Changes with Live Data
    @Query("select * from Classrooms where classroomId = :classroomId")
    LiveData<List<Classroom>> getSelectClassroom(int classroomId);
    @Query("select studentId from Classrooms where studentId = :studentId")
    LiveData<List<Integer>> getClassStudentsFromStudent(int studentId);
    @Query("select * from Classrooms where studentId = :studentId")
    LiveData<List<Classroom>> getClassFromStudent(int studentId);
    @Query("select * from Classrooms order by classroomId")
    LiveData<List<Classroom>> getAllClassrooms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertClassroom(Classroom... classrooms);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateClassroom(Classroom... classrooms);
}
