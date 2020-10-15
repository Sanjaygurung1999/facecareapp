package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistThirdActivity extends AppCompatActivity {
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    int layout;
    TextView number;
    TextView number1;
    ImageView search;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mehndi_artist_third);
        this.title = (TextView) findViewById(R.id.title);
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 11) {
            this.title.setText("Mehendi Artist for Bride");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("35"));
        }
        if (this.layout == 22) {
            this.title.setText("Mehendi Artist for Bride & Guests");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("50"));
        }
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistThirdActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MehndiArtistThirdActivity.this.layout == 11) {
                    Intent intent = new Intent(MehndiArtistThirdActivity.this, MehndiArtistFourthActivity.class);
                    intent.putExtra("layout", MehndiArtistThirdActivity.this.layout);
                    MehndiArtistThirdActivity.this.startActivity(intent);
                }
                if (MehndiArtistThirdActivity.this.layout == 22) {
                    Intent intent2 = new Intent(MehndiArtistThirdActivity.this, MehndiArtistBrideGusestSixActivity.class);
                    intent2.putExtra("layout", MehndiArtistThirdActivity.this.layout);
                    MehndiArtistThirdActivity.this.startActivity(intent2);
                }
            }
        });
    }
}
