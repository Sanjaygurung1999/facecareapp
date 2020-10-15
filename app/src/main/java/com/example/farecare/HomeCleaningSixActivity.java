package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import at.grabner.circleprogress.CircleProgressView;

public class HomeCleaningSixActivity extends AppCompatActivity {
    ImageView back_img;
    CardView cardview;
    CircleProgressView circleProgressView;
    int layout;
    LinearLayout linear;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_cleaning_six);
        this.title = (TextView) findViewById(R.id.title);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 1) {
            this.title.setText("Select Payment Method");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("85"));
        }
        if (this.layout == 2) {
            this.title.setText("Select Payment Method");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("85"));
        }
        if (this.layout == 3) {
            this.title.setText("Select Payment Method");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("85"));
        }
        if (this.layout == 4) {
            this.title.setText("Select Payment Method");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("85"));
        }
        if (this.layout == 5) {
            this.title.setText("Select Payment Method");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("85"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeCleaningSixActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HomeCleaningSixActivity.this.layout == 1) {
                    Intent intent = new Intent(HomeCleaningSixActivity.this, HomeCleaningSevenActivity.class);
                    intent.putExtra("layout", 1);
                    HomeCleaningSixActivity.this.startActivity(intent);
                }
                if (HomeCleaningSixActivity.this.layout == 2) {
                    Intent intent2 = new Intent(HomeCleaningSixActivity.this, HomeCleaningSevenActivity.class);
                    intent2.putExtra("layout", 2);
                    HomeCleaningSixActivity.this.startActivity(intent2);
                }
                if (HomeCleaningSixActivity.this.layout == 3) {
                    Intent intent3 = new Intent(HomeCleaningSixActivity.this, HomeCleaningSevenActivity.class);
                    intent3.putExtra("layout", 3);
                    HomeCleaningSixActivity.this.startActivity(intent3);
                }
                if (HomeCleaningSixActivity.this.layout == 4) {
                    Intent intent4 = new Intent(HomeCleaningSixActivity.this, HomeCleaningSevenActivity.class);
                    intent4.putExtra("layout", 4);
                    HomeCleaningSixActivity.this.startActivity(intent4);
                }
                if (HomeCleaningSixActivity.this.layout == 5) {
                    Intent intent5 = new Intent(HomeCleaningSixActivity.this, HomeCleaningSevenActivity.class);
                    intent5.putExtra("layout", 5);
                    HomeCleaningSixActivity.this.startActivity(intent5);
                }
            }
        });
    }
}
