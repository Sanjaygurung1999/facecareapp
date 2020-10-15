package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovingHomeEightActivity extends AppCompatActivity {
    ImageView back_img;
    ImageView search;
    TextView title;
    TextView type;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_moving_home_eight);
        this.type = (TextView) findViewById(R.id.type);
        this.type.setText("Moving Home");
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Packers & Movers");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MovingHomeEightActivity.this.onBackPressed();
            }
        });
    }
}

