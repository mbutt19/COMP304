package com.example.group3_comp304sec002_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class ClassroomActivity extends AppCompatActivity {
    private ClassroomViewModel classVM;
    private String results;
    private Button loadBtn;
    private Button updateBtn;
    private int sidInput;
    private Classroom classroom;
    private RadioButton rb;
    private boolean acBool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        EditText cid = findViewById(R.id.classCid);
        EditText sid = findViewById(R.id.classSid);
        EditText pid = findViewById(R.id.classPid);
        EditText floor = findViewById(R.id.floor);
        EditText wall = findViewById(R.id.wall);
        RadioGroup ac = findViewById(R.id.radioGroup);

        classVM = ViewModelProviders.of(this).get(ClassroomViewModel.class);

        loadBtn = findViewById(R.id.loadClassBtn);
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sidInput = Integer.parseInt(sid.getText().toString());
                classVM.getClassFromStudent(sidInput).observe(ClassroomActivity.this,
                        new Observer<List<Classroom>>(){
                            @Override
                            public void onChanged(List<Classroom> classrooms) {
                                if(!classrooms.isEmpty()){
                                    classroom = classrooms.remove(0);
                                    pid.setText(Integer.toString(classroom.getProfessorId()));
                                    cid.setText(Integer.toString(classroom.getClassroomId()));
                                    floor.setText(Integer.toString(classroom.getFloor()));
                                    wall.setText(classroom.getWallColor());
                                    if(classroom.isAc()){
                                        ac.check(R.id.tRdo);
                                    }
                                    else{
                                        ac.check(R.id.fRdo);
                                    }
                                }else{
                                    Toast.makeText(ClassroomActivity.this, "Enter Student ID#", Toast.LENGTH_LONG);
                                }
                            }
                        });
            }
        });
        updateBtn = findViewById(R.id.updateClassBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cid.getText().toString().isEmpty() || pid.getText().toString().isEmpty() ||
                        sid.getText().toString().isEmpty() || floor.getText().toString().isEmpty()||
                        wall.getText().toString().isEmpty()){
                    Toast.makeText(ClassroomActivity.this, "Complete All Fields To Continue", Toast.LENGTH_SHORT);
                }
                else{
                    switch (ac.getCheckedRadioButtonId()){
                        case R.id.tRdo:
                            acBool = true;
                            break;
                        case R.id.fRdo:
                            acBool = false;
                            break;
                    }
                    classroom = new Classroom(Integer.parseInt(cid.getText().toString()),
                            Integer.parseInt(pid.getText().toString()), Integer.parseInt(floor.getText().toString()),
                            true,wall.getText().toString(),Integer.parseInt(sid.getText().toString()));
                    classVM.insertClassroom(classroom);
                    Toast.makeText(ClassroomActivity.this, "Database Updated", Toast.LENGTH_LONG);
                }
            }
        });
    }
}