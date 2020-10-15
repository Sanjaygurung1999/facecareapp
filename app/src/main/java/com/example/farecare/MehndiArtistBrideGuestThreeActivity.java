package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistBrideGuestThreeActivity extends AppCompatActivity {
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    TextView number;
    TextView number1;
    ImageView search;
    TextView textView;
    TextView title;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mehndi_artist_bride_guest_three);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("30"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Mehendi Artist for Bride & Guests");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistBrideGuestThreeActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MehndiArtistBrideGuestThreeActivity.this, MehndiArtistSecondActivity.class);
                intent.putExtra("layout", 22);
                MehndiArtistBrideGuestThreeActivity.this.startActivity(intent);
            }
        });
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.incrementProgressBy(1);
        this.textView = (TextView) findViewById(R.id.textView2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MehndiArtistBrideGuestThreeActivity.this.textView.setText(String.valueOf((i / 1) * 1));
            }
        });
    }
}
