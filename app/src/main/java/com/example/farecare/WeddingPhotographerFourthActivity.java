package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import at.grabner.circleprogress.CircleProgressView;

public class WeddingPhotographerFourthActivity extends AppCompatActivity implements RobotoCalendarView.RobotoCalendarListener {
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    private RobotoCalendarView robotoCalendarView;
    ImageView search;
    TextView title;
    TextView type;

    public void onDayClick(Date date) {
    }

    public void onDayLongClick(Date date) {
    }

    public void onLeftButtonClick() {
    }

    public void onRightButtonClick() {
    }

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wedding_photographer_fourth);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("44"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Wedding & Events");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Wedding Photographer");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WeddingPhotographerFourthActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WeddingPhotographerFourthActivity.this.startActivity(new Intent(WeddingPhotographerFourthActivity.this, WeddingPhotographerFifthActivity.class));
            }
        });
        this.robotoCalendarView = (RobotoCalendarView) findViewById(R.id.robotoCalendarPicker);
        Calendar instance = Calendar.getInstance();
        Random random = new Random(System.currentTimeMillis());
        random.nextInt(2);
        instance.set(5, random.nextInt(instance.getActualMaximum(5)));
        this.robotoCalendarView.setRobotoCalendarListener(this);
        this.robotoCalendarView.setShortWeekDays(false);
        this.robotoCalendarView.showDateTitle(true);
        this.robotoCalendarView.setDate(new Date());
    }
}