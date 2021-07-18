package com.example.group3_comp304sec002_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface StudentDao {
    //
    @Insert
    void insert(Student student);
    //Monitoring Query Result Changes with Live Data
    @Query("select * from Student where studentId=studentId")
    LiveData<List<Student>> getAllPersons();
}
