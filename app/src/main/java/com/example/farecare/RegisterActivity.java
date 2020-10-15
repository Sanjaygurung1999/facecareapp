package com.example.farecare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
   // private Button r_button;
    private EditText editTextEmail,editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();

        mAuth=FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser()!=null){
            //Login activity
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

        editTextEmail= findViewById(R.id.editTextEmail);
        editTextPass=findViewById(R.id.editTextPassword);


       Button r_button=findViewById(R.id.cirRegisterButton);
        r_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser(){
        String email=editTextEmail.getText().toString().trim();
        final String password=editTextPass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Enter you email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering User!");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
           if (task.isSuccessful()){
               finish();
               Toast.makeText(RegisterActivity.this, "Registered Successfully" +
                       "Proceed to login..!!", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(getApplicationContext(),LoginActivity.class));
           }
           else {
               Toast.makeText(RegisterActivity.this, "Couldn't register %s" +
                       "Please try again..!! ", Toast.LENGTH_SHORT).show();
           }
                progressDialog.cancel();
            }
        });
    }


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    public void onLoginClick(View view){
        startActivity(new Intent(this,LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);

    }

 //   @Override
   // protected void onStart() {
    //    super.onStart();
      //  FirebaseUser currentUser=mAuth.getCurrentUser();
      //  updateUI(currentUser);
   // }

   // private void updateUI(FirebaseUser currentUser) {

    //}

}
