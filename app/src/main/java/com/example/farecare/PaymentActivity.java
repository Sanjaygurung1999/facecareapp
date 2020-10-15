package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import at.grabner.circleprogress.CircleProgressView;

public class PaymentActivity extends AppCompatActivity {
    ImageView back_img;
    CardView cardview;
    CircleProgressView circleProgressView;
    int layout;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_payment);
        this.title = (TextView) findViewById(R.id.title);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 1) {
            this.title.setText("Salon at home for Women");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("90"));
        }
        if (this.layout == 2) {
            this.title.setText("Attending Wedding, Party etc.");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("87"));
        }
        if (this.layout == 3) {
            this.title.setText("Bridal Makeup Artist");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("87"));
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
            this.circleProgressView.setValue(Float.parseFloat("87"));
        }
        if (this.layout == 22) {
            this.title.setText("Mehendi Artist for Bride & Guests");
        }
        if (this.layout == 33) {
            this.title.setText("Mehendi Artist for Bride & Guests");
        }
        if (this.layout == 44) {
            this.title.setText("Mehendi Artist for Bride & Guests");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("90"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PaymentActivity.this.onBackPressed();
            }
        });
        this.cardview = (CardView) findViewById(R.id.cardview);
        this.cardview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PaymentActivity.this.layout == 1) {
                    Intent intent = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent);
                }
                if (PaymentActivity.this.layout == 2) {
                    Intent intent2 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent2.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent2);
                }
                if (PaymentActivity.this.layout == 3) {
                    Intent intent3 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent3.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent3);
                }
                if (PaymentActivity.this.layout == 4) {
                    Intent intent4 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent4.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent4);
                }
                if (PaymentActivity.this.layout == 11) {
                    Intent intent5 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent5.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent5);
                }
                if (PaymentActivity.this.layout == 22) {
                    Intent intent6 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent6.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent6);
                }
                if (PaymentActivity.this.layout == 33) {
                    Intent intent7 = new Intent(PaymentActivity.this, OrderSucessActivity.class);
                    intent7.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent7);
                }
                if (PaymentActivity.this.layout == 44) {
                    Intent intent8 = new Intent(PaymentActivity.this, MehndiArtistBrideGuestNineActivity.class);
                    intent8.putExtra("layout", PaymentActivity.this.layout);
                    PaymentActivity.this.startActivity(intent8);
                }
            }
        });
    }
}
