package com.example.group3_comp304sec002_lab4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Professor.class, Student.class, Classroom.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "AppDB";
    public abstract StudentDao studentDao();
    public abstract ProfessorDao professorDao();
    public abstract ClassroomDao classroomDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
