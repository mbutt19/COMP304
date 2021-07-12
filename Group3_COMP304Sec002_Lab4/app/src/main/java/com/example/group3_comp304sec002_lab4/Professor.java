package com.example.group3_comp304sec002_lab4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Professor {

    @PrimaryKey(autoGenerate = true)
    private int professorId;
    private String firstName;
    private String lastName;
    private String department;
    private String password;

    // Constructor with all attributes
    public Professor(int professorId, String firstName, String lastName, String department, String password) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.password = password;
    }
    // GETTERS
    public int getProfessorId() { return professorId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }
    public String getPassword() { return password; }

    // SETTERS
    public void setProfessorId(int professorId) { this.professorId = professorId; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setDepartment(String department) { this.department = department; }
    public void setPassword(String password) { this.password = password; }
}