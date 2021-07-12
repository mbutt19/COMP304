package com.example.group3_comp304sec002_lab4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int studentId;
    private String firstName;
    private String lastName;
    private String department;
    private List<Integer> professorIds;
    private String homeRoom;

    // Constructor with all attributes
    public Student(int studentId, String firstName, String lastName, String department, String homeRoom) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.homeRoom = homeRoom;
        this.professorIds = new ArrayList<>(); {
        }
    }
    // GETTERS
    public int getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }
    public String getHomeRoom() { return homeRoom; }

    // SETTERS
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDepartment(String department) { this.department = department; }
    public void setHomeRoom(String homeRoom) { this.homeRoom = homeRoom; }

    // Setter for professors list
    public void addProfessorIds(int professorId) { this.professorIds.add(professorId); }
    public void addProfessorIds(Collection<? extends Integer> professorIds) {
        this.professorIds.addAll(professorIds); }
}