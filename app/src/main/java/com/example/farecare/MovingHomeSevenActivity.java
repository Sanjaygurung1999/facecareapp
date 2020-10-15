package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MovingHomeSevenActivity extends AppCompatActivity {
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
        setContentView((int) R.layout.activity_moving_home_seven);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Select Payment Method");
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("100"));
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MovingHomeSevenActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MovingHomeSevenActivity.this.startActivity(new Intent(MovingHomeSevenActivity.this, MovingHomeEightActivity.class));
            }
        });
    }
}
