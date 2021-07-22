package com.example.group3_comp304sec002_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private ProfessorViewModel profVM;
    private Professor prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.userID);
        password = findViewById(R.id.userPass);
        profVM = ViewModelProviders.of(this).get(ProfessorViewModel.class);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        Button viewBtn = findViewById(R.id.loginBtn2);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = user.getText().toString();
                String pw = password.getText().toString();
                int intID = Integer.parseInt(id);
                if(id.isEmpty() || pw.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Complete All Fields", Toast.LENGTH_LONG);
                }
                else{
                    profVM.findProfessor(intID).observe(LoginActivity.this,
                            new Observer<List<Professor>>(){
                                @Override
                                public void onChanged(List<Professor> professors) {
                                    Integer res = profVM.insertResult.getValue();
                                    if (res == 1) {
                                        prof = professors.remove(0);
                                        if (prof.getPassword().toLowerCase().equals(pw.toLowerCase())) {
                                            SharedPreferences.Editor editor = sharedpreferences.edit();
                                            editor.putBoolean("loggedIn",true);
                                            editor.commit();
                                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(intent);
                                        } else{
                                            Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_LONG);
                                        }
                                    }
                                }
                            });

                    }
                }
            }
        );

    }
}