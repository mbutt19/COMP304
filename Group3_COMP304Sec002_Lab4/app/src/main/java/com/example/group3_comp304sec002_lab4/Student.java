package com.example.group3_comp304sec002_lab4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int studentId;
    private String firstName;
    private String lastName;
    private String department;
    private final int professorId;
    private int classroom;

    // Constructor with all attributes
    public Student(int studentId, String firstName, String lastName, String department, int classroom, int professorId) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.classroom = classroom;
        this.professorId = professorId;
    }
    // GETTERS
    public int getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }
    public int getClassroom() { return classroom; }
    public int getProfessorId() { return professorId; }

    // SETTERS
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDepartment(String department) { this.department = department; }
    public void setClassroom(int classroom) { this.classroom = classroom; }
    public void setProfessorId(int professorId) { this.studentId = professorId; }
}