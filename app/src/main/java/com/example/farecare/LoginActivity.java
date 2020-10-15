package com.example.farecare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText editTextEmail,editTextPass;
    private ProgressDialog progressDialog;
    // private Button l_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

        }
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPass=findViewById(R.id.editTextPassword);

        Button l_button=findViewById(R.id.cirLoginButton);
        l_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           loginUser();
            }
        });
    }

    private void loginUser(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPass.getText().toString().trim();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Logging in..!!");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    Toast.makeText(LoginActivity.this, "Login Successful" +
                            "\nWelcome", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login failed.." +
                            "\nPlease try again..!", Toast.LENGTH_SHORT).show();
                }
                progressDialog.cancel();
            }
        });

    }

    public void onLoginClick(View View){
        finish();
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }


}
