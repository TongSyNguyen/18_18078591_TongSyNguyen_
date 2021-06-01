package com.example.a18_18078591_tongsynguyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnLogin, btnExit;
    EditText txtEmail, txtPass;
    TextView txtLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        txtLogin = findViewById(R.id.txtLogin);


        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });

    }

    private void DangNhap(){
        String emails = txtEmail.getText().toString();
        String passwords = txtPass.getText().toString();
        mAuth.signInWithEmailAndPassword(emails, passwords)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent2 = new Intent(MainActivity.this,Home.class);
                            startActivity(intent2);
                        } else {
                            Toast.makeText(MainActivity.this,"Lỗi",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}