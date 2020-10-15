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

public class BlocksLeakageOneActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back_img;
    Button button;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CircleProgressView circleProgressView;
    ImageView search;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_blocks_leakage_one);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("12"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Plumber");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Blocks & Leakages");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageOneActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageOneActivity.this.startActivity(new Intent(BlocksLeakageOneActivity.this, BlocksLeakageSecondActivity.class));
            }
        });
        this.checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        this.checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        this.checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        this.checkBox5 = (CheckBox) findViewById(R.id.checkbox5);
        this.checkBox1.setOnClickListener(this);
        this.checkBox2.setOnClickListener(this);
        this.checkBox3.setOnClickListener(this);
        this.checkBox4.setOnClickListener(this);
        this.checkBox5.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkbox1 /*2131361867*/:
                this.checkBox1.setChecked(true);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(false);
                this.checkBox5.setChecked(false);
                return;
            case R.id.checkbox2 /*2131361868*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(true);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(false);
                this.checkBox5.setChecked(false);
                return;
            case R.id.checkbox3 /*2131361869*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(true);
                this.checkBox4.setChecked(false);
                this.checkBox5.setChecked(false);
                return;
            case R.id.checkbox4 /*2131361870*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(true);
                this.checkBox5.setChecked(false);
                return;
            case R.id.checkbox5 /*2131361871*/:
                this.checkBox1.setChecked(false);
                this.checkBox2.setChecked(false);
                this.checkBox3.setChecked(false);
                this.checkBox4.setChecked(false);
                this.checkBox5.setChecked(true);
                return;
            default:
                return;
        }
    }
}
