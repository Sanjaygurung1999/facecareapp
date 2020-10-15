package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class PestControlSevenActivity extends AppCompatActivity {
    ImageView back_img;
    CircleProgressView circleProgressView;
    LinearLayout linear;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pest_control_seven);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("100"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Pest Control");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Cockroach Control");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PestControlSevenActivity.this.onBackPressed();
            }
        });
    }
}

