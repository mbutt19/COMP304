package com.example.group3_comp304sec002_lab4;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(tableName = "Classrooms")
public class Classroom {

    @PrimaryKey(autoGenerate = true)
    private int classroomId;
    private int professorId;
    private int studentId;
    //private List<Integer> studentIds;
    private int floor;
    private boolean ac;
    private String wallColor;

    // Constructor with all attributes
    public Classroom(int classroomId, int professorId, int floor, boolean ac, String wallColor, int studentId) {
        this.classroomId = classroomId;
        this.professorId = professorId;
        this.floor = floor;
        this.ac = ac;
        this.studentId = studentId;
        //this.studentIds = studentIds.subList(0, -1);
        this.wallColor = wallColor;
    }
    // GETTERS
    public int getClassroomId() { return classroomId; }
    public int getProfessorId() { return professorId; }
    public int getStudentId() { return studentId; }
    //public List<Integer> getStudentIds() { return studentIds;}
    public int getFloor() { return floor; }
    public String getWallColor() { return wallColor; }
    public boolean isAc() { return ac; }

    // SETTERS
    public void setClassroomId(int classroomId) { this.classroomId = classroomId; }
    //public void setStudentIds(List<Integer> studentIds) { this.studentIds = studentIds.subList(0, -1); }
    public void setProfessorId(int professorId) { this.professorId = professorId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setAc(boolean ac) { this.ac = ac; }
    public void setWallColor(String wallColor) { this.wallColor = wallColor; }

    // Setter for students list
    //public void addStudent(int studentId) { this.studentIds.add(studentId); }
    //public void addStudents(Collection<? extends Integer> studentIds) {
        //this.studentIds.addAll(studentIds); }
}