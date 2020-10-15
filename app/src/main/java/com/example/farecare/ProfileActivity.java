package com.example.farecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
   // LinearLayout personal_info,experience,review;
    LinearLayout personal_info;
    //TextView personal_info_btn,experience_btn, review_btn;
    TextView personal_info_btn,edit_btn;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth=FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

        personal_info=findViewById(R.id.personalinfo);
    //    experience=findViewById(R.id.experience);
        //    review=findViewById(R.id.review);
        personal_info_btn=findViewById(R.id.personalinfobtn);
     //   experience_btn=findViewById(R.id.experiencebtn);
     //   review_btn=findViewById(R.id.reviewbtn);
        //making personal info visible
        personal_info.setVisibility(View.VISIBLE);
      //  experience.setVisibility(View.GONE);
      //  review.setVisibility(View.GONE);
        edit_btn=findViewById(R.id.editBtn);
        back_btn=findViewById(R.id.backBtn);

//        personal_info_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                personal_info.setVisibility(View.VISIBLE);
//                experience.setVisibility(View.GONE);
//                review.setVisibility(View.GONE);
//                personal_info_btn.setTextColor(getResources().getColor(R.color.blue));
//                experience_btn.setTextColor(getResources().getColor(R.color.grey));
//                review_btn.setTextColor(getResources().getColor(R.color.grey));
//            }
//        });
//
//        experience_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                personal_info.setVisibility(View.GONE);
//                experience.setVisibility(View.VISIBLE);
//                review.setVisibility(View.GONE);
//                personal_info_btn.setTextColor(getResources().getColor(R.color.grey));
//                experience_btn.setTextColor(getResources().getColor(R.color.blue));
//                review_btn.setTextColor(getResources().getColor(R.color.grey));
//            }
//        });
//
//        review_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                personal_info.setVisibility(View.VISIBLE);
//                experience.setVisibility(View.GONE);
//                review.setVisibility(View.VISIBLE);
//                personal_info_btn.setTextColor(getResources().getColor(R.color.blue));
//                experience_btn.setTextColor(getResources().getColor(R.color.grey));
//                review_btn.setTextColor(getResources().getColor(R.color.blue));
//            }
//        });

        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EditProfileActivity.class));
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
            }
        });


//       firebase user= mAuth.getCurrentUser();

//        TextView textViewEmail = findViewById(R.id.textViewUserEmail);
//        textViewEmail.setText(String.format("Welcome %s", user.getEmail()));
//
//        Button buttonLogout = findViewById(R.id.buttonLogout);
//        buttonLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            mAuth.signOut();
//            finish();
//            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//            }
//        });
    }
}