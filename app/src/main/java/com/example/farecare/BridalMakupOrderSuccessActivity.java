package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BridalMakupOrderSuccessActivity extends AppCompatActivity {
    ImageView back_img;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bridal_makup_order_success);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Bridal Makeup Artist");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BridalMakupOrderSuccessActivity.this.onBackPressed();
            }
        });
    }
}