package com.example.group3_comp304sec002_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdateInfoActivity extends AppCompatActivity {
    private StudentViewModel studentVM;
    private Button displayBtn;
    private Button updateBtn;
    private int sidInput;
    private Student stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        // Inputs
        EditText sid = findViewById(R.id.studentIdInput);
        EditText cid = findViewById(R.id.studentHrInput);
        EditText pid = findViewById(R.id.professorList);
        EditText fn = findViewById(R.id.studentFNInput);
        EditText ln = findViewById(R.id.studentLnInput);
        EditText dept = findViewById(R.id.studentDeptInput);
        // View model
        studentVM = ViewModelProviders.of(this).get(StudentViewModel.class);

        displayBtn = findViewById(R.id.studentDisplayBtn);
        displayBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    sidInput = Integer.parseInt(sid.getText().toString());
                    studentVM.getSelectStudent(sidInput).observe(UpdateInfoActivity.this,
                            new Observer<List<Student>>() {
                                @Override
                                public void onChanged(@Nullable List<Student> student) {
                                    if (!student.isEmpty()) {
                                        stu = student.remove(0);
                                        Toast.makeText(UpdateInfoActivity.this, stu.toString(), Toast.LENGTH_LONG);
                                        pid.setText(Integer.toString(stu.getProfessorId()));
                                        cid.setText(Integer.toString(stu.getClassroom()));
                                        fn.setText(stu.getFirstName());
                                        ln.setText(stu.getLastName());
                                        dept.setText(stu.getDepartment());
                                    } else {
                                        Toast.makeText(UpdateInfoActivity.this, "Enter Student ID#", Toast.LENGTH_LONG);
                                    }
                                }
                            });
                }
                catch (Exception e){
                    Toast.makeText(UpdateInfoActivity.this, "Student ID# Not Found", Toast.LENGTH_LONG);
                }
            }
        });

        updateBtn = findViewById(R.id.studentUpdateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sid.getText().toString().isEmpty()){
                    Toast.makeText(UpdateInfoActivity.this, "Enter Student ID# To Continue", Toast.LENGTH_SHORT);
                }
                if(pid.getText().toString() == ""){
                    Toast.makeText(UpdateInfoActivity.this, "Enter Professor ID# To Continue", Toast.LENGTH_SHORT);
                }
                if(cid.getText().toString() == ""){
                    Toast.makeText(UpdateInfoActivity.this, "Enter Classroom ID# To Continue", Toast.LENGTH_SHORT);
                }
                if(fn.getText().toString() == ""){
                    Toast.makeText(UpdateInfoActivity.this, "Enter First Name To Continue", Toast.LENGTH_SHORT);
                }
                if(ln.getText().toString() == ""){
                    Toast.makeText(UpdateInfoActivity.this, "Enter Last NameTo Continue", Toast.LENGTH_SHORT);
                }
                if(dept.getText().toString() == ""){
                    Toast.makeText(UpdateInfoActivity.this, "Enter Department To Continue", Toast.LENGTH_SHORT);
                }
                try {
                    sidInput = Integer.parseInt(sid.getText().toString());
                    stu = new Student((sidInput), fn.getText().toString(), ln.getText().toString(),
                            dept.getText().toString(), Integer.parseInt(cid.getText().toString()),
                            Integer.parseInt(pid.getText().toString()));
                    studentVM.insertStudent(stu);
                    Toast.makeText(UpdateInfoActivity.this, "Database Updated", Toast.LENGTH_LONG);
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(UpdateInfoActivity.this, "Complete All Fields", Toast.LENGTH_LONG);
                }
            }
        });
    }
}