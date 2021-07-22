package com.example.group3_comp304sec002_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentActivity extends AppCompatActivity {
    private StudentViewModel studentVM;
    private String results;
    private TextView stuTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        stuTv = findViewById(R.id.studentTv);
        studentVM = ViewModelProviders.of(this).get(StudentViewModel.class);

        // View Student Button Implementation
        Button viewBtn = findViewById(R.id.viewStudentBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            //Implement the event handler method
            public void onClick(View v) {
                try {
                    EditText studentIn = findViewById(R.id.studentInput);
                    int idNum = Integer.parseInt(studentIn.getText().toString());
                    // Query call for matching student id
                    studentVM.getSelectStudent(idNum).observe(StudentActivity.this,
                            new Observer<List<Student>>() {
                                @Override
                                public void onChanged(@Nullable List<Student> student) {
                                    if (!student.isEmpty()) {
                                        Student stu = student.remove(0);
                                        results = "ID#: " + stu.getStudentId() + "\nFirst Name: " + stu.getFirstName() +
                                                "\nLast Name: " + stu.getLastName() + "\nDepartment: " + stu.getDepartment() +
                                                "\nClassroom: " + stu.getClassroom() + "\nProfessor Id: " + stu.getProfessorId();
                                        stuTv.setText(results);
                                    } else {
                                        stuTv.setText("NOT FOUND - Invalid ID#");
                                    }
                                }
                            });
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(StudentActivity.this, "Enter Valid ID#", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(StudentActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        // Update Button Implementation
        Button updateBtn = findViewById(R.id.updateStudentBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            //Implement the event handler method
            public void onClick(View v) {
                Intent intent = new Intent(StudentActivity.this, UpdateInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}