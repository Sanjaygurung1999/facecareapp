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

public class WeddingPhotographerOneActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back_img;
    Button button;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CircleProgressView circleProgressView;
    ImageView search;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wedding_photographer_one);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("11"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Wedding & Events");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Wedding Photographer");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WeddingPhotographerOneActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WeddingPhotographerOneActivity.this.startActivity(new Intent(WeddingPhotographerOneActivity.this, WeddingPhotographerSecondActivity.class));
            }
        });
        this.checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        this.checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        this.checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        this.checkBox1.setOnClickListener(this);
        this.checkBox2.setOnClickListener(this);
        this.checkBox3.setOnClickListener(this);
        this.checkBox4.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkbox1 /*2131361867*/:
                this.checkBox1.setChecked(true);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(false);
                return;
            case R.id.checkbox2 /*2131361868*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(true);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(false);
                return;
            case R.id.checkbox3 /*2131361869*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(true);
                this.checkBox4.setChecked(false);
                return;
            case R.id.checkbox4 /*2131361870*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(true);
                return;
            default:
                return;
        }
    }
}
