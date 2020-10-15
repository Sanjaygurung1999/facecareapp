package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class AcOneActivity extends AppCompatActivity {
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    /* access modifiers changed from: private */

    /* renamed from: id */
    private int id;
    TextView number;
    TextView number1;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioGroup radiogroup;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ac_one);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("12"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("AC");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AcOneActivity.this.onBackPressed();
            }
        });
        this.radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        this.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                AcOneActivity.this.id = i;
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switch (AcOneActivity.this.id) {
                    case R.id.radio1 /*2131362010*/:
                        AcOneActivity.this.startActivity(new Intent(AcOneActivity.this, AcSecondActivity.class));
                        return;
                    case R.id.radio2 /*2131362011*/:
                        return;
                    default:
                        Toast.makeText(AcOneActivity.this, "Please select anyone item", Toast.LENGTH_SHORT).show();
                        return;
                }
            }
        });
    }
}