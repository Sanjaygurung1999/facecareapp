package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import at.grabner.circleprogress.CircleProgressView;

public class MakupAndHairSixActivity extends AppCompatActivity {
    CardView CardViewOffer;
    Button ContinueButton;
    ImageView add;
    ImageView add1;
    int adult = 1;
    ImageView back_img;
    LinearLayout bottom_linear;
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

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_makup_and_hair_six);
        this.title = (TextView) findViewById(R.id.title);
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakupAndHairSixActivity.this.onBackPressed();
            }
        });
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 3) {
            this.title.setText("Bridal Makeup Artist");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("75"));
        }
        if (this.layout == 4) {
            this.title.setText("Mehendi Artist for Bride");
        }
        if (this.layout == 11) {
            this.title.setText("Mehendi Artist for Bride");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("75"));
        }
        if (this.layout == 22) {
            this.title.setText("Mehendi Artist for Bride & Guests");
        }
        if (this.layout == 33) {
            this.title.setText("Mehendi Artist for Bride & Guests");
        }
        this.ContinueButton = (Button) findViewById(R.id.ContinueButton);
        this.ContinueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MakupAndHairSixActivity.this, PaymentActivity.class);
                intent.putExtra("layout", MakupAndHairSixActivity.this.layout);
                MakupAndHairSixActivity.this.startActivity(intent);
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakupAndHairSixActivity.this.count++;
                MakupAndHairSixActivity.this.number.setText(String.valueOf(MakupAndHairSixActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MakupAndHairSixActivity.this.count != 1) {
                    MakupAndHairSixActivity.this.count--;
                    MakupAndHairSixActivity.this.number.setText(String.valueOf(MakupAndHairSixActivity.this.count));
                }
            }
        });
    }
}

