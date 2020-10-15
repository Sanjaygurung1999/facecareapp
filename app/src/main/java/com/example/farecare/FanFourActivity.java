package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class FanFourActivity extends AppCompatActivity {
    ImageView add;
    ImageView add1;
    int adult = 1;
    ImageView back_img;
    LinearLayout bottom_linear;
    LinearLayout bottom_linear1;
    Button button;
    CircleProgressView circleProgressView;
    int count = 1;
    int layout;
    LinearLayout linear_add;
    LinearLayout linear_add1;
    LinearLayout linear_count;
    LinearLayout linear_count1;
    ImageView minus;
    ImageView minus1;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;
    TextView txt1;
    TextView txt2;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fan_four);
        this.type = (TextView) findViewById(R.id.type);
        this.title = (TextView) findViewById(R.id.title);
        this.txt1 = (TextView) findViewById(R.id.txt1);
        this.txt2 = (TextView) findViewById(R.id.txt2);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 1) {
            this.type.setText("Electrician");
            this.title.setText("Fan");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("50"));
        }
        if (this.layout == 2) {
            this.type.setText("Electrician");
            this.title.setText("Light");
            this.txt1.setText("Tube Lights");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("50"));
        }
        if (this.layout == 3) {
            this.type.setText("Electrician");
            this.title.setText("Inverter");
            this.txt1.setText("Inverter");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        if (this.layout == 4) {
            this.type.setText("Electrician");
            this.title.setText("Full home Health Check");
            this.txt1.setText("Full home Health Check");
            this.txt2.setText("1BHK - $150");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FanFourActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FanFourActivity.this, FanFifthActivity.class);
                intent.putExtra("layout", FanFourActivity.this.layout);
                FanFourActivity.this.startActivity(intent);
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FanFourActivity.this.count++;
                FanFourActivity.this.number.setText(String.valueOf(FanFourActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FanFourActivity.this.count != 1) {
                    FanFourActivity.this.count--;
                    FanFourActivity.this.number.setText(String.valueOf(FanFourActivity.this.count));
                }
            }
        });
    }
}