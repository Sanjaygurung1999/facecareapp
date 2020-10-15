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

public class HomeCleaningThreeActivity extends AppCompatActivity {
    ImageView add;
    ImageView add1;
    int adult = 1;
    ImageView back_img;
    LinearLayout bottom_linear;
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
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_cleaning_three);
        this.type = (TextView) findViewById(R.id.type);
        this.title = (TextView) findViewById(R.id.title);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 1) {
            this.type.setText("Home Cleaning");
            this.title.setText("Home Deep Cleaning");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        if (this.layout == 2) {
            this.type.setText("Home Cleaning");
            this.title.setText("Kitchen Deep Cleaning");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        if (this.layout == 3) {
            this.type.setText("Home Cleaning");
            this.title.setText("Carpet Cleaning");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        if (this.layout == 4) {
            this.type.setText("Home Cleaning");
            this.title.setText("Bathroom Cleaning");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("42"));
        }
        if (this.layout == 5) {
            this.type.setText("Home Cleaning");
            this.title.setText("Sofa Cleaning");
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
                HomeCleaningThreeActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeCleaningThreeActivity.this.layout == 1) {
                    Intent intent = new Intent(HomeCleaningThreeActivity.this, HomeCleaningFourthActivity.class);
                    intent.putExtra("layout", 1);
                    HomeCleaningThreeActivity.this.startActivity(intent);
                }
                if (HomeCleaningThreeActivity.this.layout == 2) {
                    Intent intent2 = new Intent(HomeCleaningThreeActivity.this, HomeCleaningFourthActivity.class);
                    intent2.putExtra("layout", 2);
                    HomeCleaningThreeActivity.this.startActivity(intent2);
                }
                if (HomeCleaningThreeActivity.this.layout == 3) {
                    Intent intent3 = new Intent(HomeCleaningThreeActivity.this, HomeCleaningFourthActivity.class);
                    intent3.putExtra("layout", 3);
                    HomeCleaningThreeActivity.this.startActivity(intent3);
                }
                if (HomeCleaningThreeActivity.this.layout == 4) {
                    Intent intent4 = new Intent(HomeCleaningThreeActivity.this, HomeCleaningFourthActivity.class);
                    intent4.putExtra("layout", 4);
                    HomeCleaningThreeActivity.this.startActivity(intent4);
                }
                if (HomeCleaningThreeActivity.this.layout == 5) {
                    Intent intent5 = new Intent(HomeCleaningThreeActivity.this, HomeCleaningFourthActivity.class);
                    intent5.putExtra("layout", 5);
                    HomeCleaningThreeActivity.this.startActivity(intent5);
                }
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeCleaningThreeActivity.this.count++;
                HomeCleaningThreeActivity.this.number.setText(String.valueOf(HomeCleaningThreeActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeCleaningThreeActivity.this.count != 1) {
                    HomeCleaningThreeActivity.this.count--;
                    HomeCleaningThreeActivity.this.number.setText(String.valueOf(HomeCleaningThreeActivity.this.count));
                }
            }
        });
    }
}
