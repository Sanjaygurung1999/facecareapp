package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class HomeCleaningSecondActivity extends AppCompatActivity {
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    int layout;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_cleaning_second);
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
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
            this.circleProgressView.setValue(Float.parseFloat("28"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeCleaningSecondActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeCleaningSecondActivity.this.layout == 1) {
                    Intent intent = new Intent(HomeCleaningSecondActivity.this, HomeCleaningThreeActivity.class);
                    intent.putExtra("layout", 1);
                    HomeCleaningSecondActivity.this.startActivity(intent);
                }
                if (HomeCleaningSecondActivity.this.layout == 2) {
                    Intent intent2 = new Intent(HomeCleaningSecondActivity.this, HomeCleaningThreeActivity.class);
                    intent2.putExtra("layout", 2);
                    HomeCleaningSecondActivity.this.startActivity(intent2);
                }
                if (HomeCleaningSecondActivity.this.layout == 3) {
                    Intent intent3 = new Intent(HomeCleaningSecondActivity.this, HomeCleaningThreeActivity.class);
                    intent3.putExtra("layout", 3);
                    HomeCleaningSecondActivity.this.startActivity(intent3);
                }
                if (HomeCleaningSecondActivity.this.layout == 4) {
                    Intent intent4 = new Intent(HomeCleaningSecondActivity.this, HomeCleaningThreeActivity.class);
                    intent4.putExtra("layout", 4);
                    HomeCleaningSecondActivity.this.startActivity(intent4);
                }
                if (HomeCleaningSecondActivity.this.layout == 5) {
                    Intent intent5 = new Intent(HomeCleaningSecondActivity.this, HomeCleaningThreeActivity.class);
                    intent5.putExtra("layout", 5);
                    HomeCleaningSecondActivity.this.startActivity(intent5);
                }
            }
        });
    }
}
