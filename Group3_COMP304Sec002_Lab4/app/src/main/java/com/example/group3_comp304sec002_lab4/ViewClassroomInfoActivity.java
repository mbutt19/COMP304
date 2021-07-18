package com.example.group3_comp304sec002_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewClassroomInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classroom_info);

        // View Classroom Button Implementation
        Button viewBtn = findViewById(R.id.viewClassroomBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            //Implement the event handler method
            public void onClick(View v) {
                EditText studentIn = findViewById(R.id.studentInput2);
                String idNum = studentIn.getText().toString();
                // Query call for matching student id
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