package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistBrideGuestNineActivity extends AppCompatActivity {
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
        setContentView((int) R.layout.activity_mehndi_artist_bride_guest_nine);
        this.title = (TextView) findViewById(R.id.title);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 1) {
            this.title.setText("Salon at home for Women");
        }
        if (this.layout == 2) {
            this.title.setText("Attending Wedding, Party etc.");
        }
        if (this.layout == 3) {
            this.title.setText("Bridal Makeup Artist");
        }
        if (this.layout == 4) {
            this.title.setText("Mehendi Artist for Bride");
        }
        if (this.layout == 11) {
            this.title.setText("Mehendi Artist for Bride");
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
            this.circleProgressView.setValue(Float.parseFloat("100"));
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistBrideGuestNineActivity.this.onBackPressed();
            }
        });
    }
}
