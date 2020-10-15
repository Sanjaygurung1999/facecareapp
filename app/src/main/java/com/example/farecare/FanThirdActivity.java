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

public class FanThirdActivity extends AppCompatActivity {
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
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_fan_third);
        this.type = (TextView) findViewById(R.id.type);
        this.title = (TextView) findViewById(R.id.title);
        this.txt1 = (TextView) findViewById(R.id.txt1);
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
            this.circleProgressView.setValue(Float.parseFloat("36"));
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
            this.circleProgressView.setValue(Float.parseFloat("36"));
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FanThirdActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FanThirdActivity.this, FanFourActivity.class);
                intent.putExtra("layout", FanThirdActivity.this.layout);
                FanThirdActivity.this.startActivity(intent);
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FanThirdActivity.this.count++;
                FanThirdActivity.this.number.setText(String.valueOf(FanThirdActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FanThirdActivity.this.count != 1) {
                    FanThirdActivity.this.count--;
                    FanThirdActivity.this.number.setText(String.valueOf(FanThirdActivity.this.count));
                }
            }
        });
    }
}