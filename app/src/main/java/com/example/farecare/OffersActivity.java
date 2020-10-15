package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.OffersModelClass;
import com.example.farecare.adapter.OffersRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class OffersActivity extends AppCompatActivity {
    private OffersRecycleAdapter bAdapter;
    ImageView back_img;
    CircleProgressView circleProgressView;
    TextView number;
    TextView number1;
    private ArrayList<OffersModelClass> offersModelClasses;
    private RecyclerView recyclerView;
    ImageView search;
    TextView title;
    private String[] title1 = {"Get 10% off* ", "Get 10% off* "};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_offers);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("50"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Select Offer");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OffersActivity.this.onBackPressed();
            }
        });
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.offersModelClasses = new ArrayList<>();
        for (String offersModelClass : this.title1) {
            this.offersModelClasses.add(new OffersModelClass(offersModelClass));
        }
        this.bAdapter = new OffersRecycleAdapter(this, this.offersModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
    }
}
