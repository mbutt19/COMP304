package com.example.group3_comp304sec002_lab4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(tableName = "Classrooms")
public class Classroom {

    @PrimaryKey(autoGenerate = true)
    private int classroomId;
    private int professorId;
    private List<Integer> studentIds;
    private int floor;
    private boolean ac;

    // Constructor with all attributes
    public Classroom(int classroomId, int professorId, int floor, boolean ac) {
        this.classroomId = classroomId;
        this.professorId = professorId;
        this.floor = floor;
        this.ac = ac;
        this.studentIds = new ArrayList<>();
    }
    // GETTERS
    public int getClassroomId() { return classroomId; }
    public int getProfessorId() { return professorId; }
    public List<Integer> getStudentIds() { return studentIds;}
    public int getFloor() { return floor; }
    public boolean isAc() { return ac; }

    // SETTERS
    public void setClassroomId(int classroomId) { this.classroomId = classroomId; }
    public void setStudentIds(List<Integer> studentIds) { this.studentIds = studentIds.subList(0, -1); }
    public void setProfessorId(int professorId) { this.professorId = professorId; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setAc(boolean ac) { this.ac = ac; }

    // Setter for students list
    public void addStudent(int studentId) { this.studentIds.add(studentId); }
    public void addStudents(Collection<? extends Integer> studentIds) {
        this.studentIds.addAll(studentIds); }
}