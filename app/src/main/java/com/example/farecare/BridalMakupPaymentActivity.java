package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BridalMakupPaymentActivity extends AppCompatActivity {
    ImageView back_img;
    LinearLayout linear;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bridal_makup_payment);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Select Payment Method");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BridalMakupPaymentActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BridalMakupPaymentActivity.this.startActivity(new Intent(BridalMakupPaymentActivity.this, BridalMakupOrderSuccessActivity.class));
            }
        });
    }
}