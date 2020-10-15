package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LocationActivity extends AppCompatActivity {
    CardView cardview;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_location);
        this.cardview = (CardView) findViewById(R.id.cardview);
        this.cardview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LocationActivity.this.startActivity(new Intent(LocationActivity.this, SearchingActivity.class));
            }
        });
    }
}

