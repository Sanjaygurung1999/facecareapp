package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class InverterOneActivity extends AppCompatActivity {
    ImageView back_img;
    Button button;
    CheckBox checkBox3;
    CircleProgressView circleProgressView;
    int layout;
    TextView number;
    TextView number1;
    ImageView search;
    TextView text3;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_inverter_one);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("14"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Electrician");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Inverter");
        this.text3 = (TextView) findViewById(R.id.text3);
        this.checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InverterOneActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(InverterOneActivity.this, FanThirdActivity.class);
                intent.putExtra("layout", 3);
                InverterOneActivity.this.startActivity(intent);
            }
        });
    }
}

