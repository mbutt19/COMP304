package com.example.group3_comp304sec002_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ViewClassroomInfoActivity extends AppCompatActivity {
    private ClassroomViewModel classVM;
    private TextView classTv;
    private Classroom clas;
    private String results;
    private String acBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classroom_info);

        classTv = findViewById(R.id.classroomTv);
        classVM = ViewModelProviders.of(this).get(ClassroomViewModel.class);

        // View Classroom Button Implementation
        Button viewBtn = findViewById(R.id.viewClassroomBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            //Implement the event handler method
            public void onClick(View v) {
                EditText studentIn = findViewById(R.id.studentInput2);
                int idNum = Integer.parseInt(studentIn.getText().toString());
                // Query call for matching student id
                classVM.getClassFromStudent(idNum).observe(ViewClassroomInfoActivity.this,
                        new Observer<List<Classroom>>() {
                            @Override
                            public void onChanged(@Nullable List<Classroom> classroom) {
                                if(!classroom.isEmpty()){
                                    clas = classroom.remove(0);

                                    if(clas.isAc()){ acBool = "True"; }
                                    else{ acBool = "False"; }

                                    results = "Classroom ID: "+ clas.getClassroomId() +
                                            "\nProfessor ID: " + clas.getProfessorId() +
                                            "\nFloor: " + clas.getFloor() + "\nWall Color: " +
                                            clas.getWallColor() + "\nAC: "+ acBool +
                                            "\nStudent: " + clas.getStudentId();
                                    classTv.setText(results);
                                }
                                else{
                                    classTv.setText("NOT FOUND - Invalid ID#");
                                }
                            }
                        });
            }
        });
        // Update Button Implementation
        Button updateBtn = findViewById(R.id.updateClassroomBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            //Implement the event handler method
            public void onClick(View v) {
                Intent intent = new Intent(ViewClassroomInfoActivity.this, ClassroomActivity.class);
                startActivity(intent);
            }
        });
    }
}