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

public class BlocksLeakageFourthActivity extends AppCompatActivity {
    ImageView add;
    ImageView add1;
    int adult = 1;
    ImageView back_img;
    LinearLayout bottom_linear;
    LinearLayout bottom_linear1;
    Button button;
    CircleProgressView circleProgressView;
    int count = 1;
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
        setContentView((int) R.layout.activity_blocks_leakage_fourth);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("50"));
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Plumber");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Blocks & Leakages");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageFourthActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageFourthActivity.this.startActivity(new Intent(BlocksLeakageFourthActivity.this, BlocksLeakageFifthActivity.class));
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageFourthActivity.this.count++;
                BlocksLeakageFourthActivity.this.number.setText(String.valueOf(BlocksLeakageFourthActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BlocksLeakageFourthActivity.this.count != 1) {
                    BlocksLeakageFourthActivity.this.count--;
                    BlocksLeakageFourthActivity.this.number.setText(String.valueOf(BlocksLeakageFourthActivity.this.count));
                }
            }
        });
        this.linear_count1 = (LinearLayout) findViewById(R.id.linear_count1);
        this.add1 = (ImageView) findViewById(R.id.plus1);
        this.minus1 = (ImageView) findViewById(R.id.minus1);
        this.number1 = (TextView) findViewById(R.id.number1);
        this.add1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BlocksLeakageFourthActivity.this.count++;
                BlocksLeakageFourthActivity.this.number1.setText(String.valueOf(BlocksLeakageFourthActivity.this.count));
            }
        });
        this.minus1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BlocksLeakageFourthActivity.this.count != 1) {
                    BlocksLeakageFourthActivity.this.count--;
                    BlocksLeakageFourthActivity.this.number1.setText(String.valueOf(BlocksLeakageFourthActivity.this.count));
                }
            }
        });
    }
}