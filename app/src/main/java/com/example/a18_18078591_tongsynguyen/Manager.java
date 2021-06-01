package com.example.a18_18078591_tongsynguyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class Manager extends AppCompatActivity {
    Button btnLogout, btnShow, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);
        AnhXa();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_info();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_emp();
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private  void show_info(){
        Intent intent_showinfo = new Intent(Manager.this, Home.class);
        startActivity(intent_showinfo);
    }
    private  void add_emp(){
        Intent intent_addemp = new Intent(Manager.this, Add_employee.class);
        startActivity(intent_addemp);
    }
    private  void logout(){
        Intent intent_logout = new Intent(Manager.this, Login.class);
        startActivity(intent_logout);
    }
    private void AnhXa(){
        btnLogout = findViewById(R.id.btnLogout);
        btnShow = findViewById(R.id.btnShow);
        btnAdd = findViewById(R.id.btnAdd);
    }
}
