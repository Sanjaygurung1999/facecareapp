package com.example.farecare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.adapter.ReviewRatingRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class ReviewRatingActivity extends AppCompatActivity {
    private ReviewRatingRecycleAdapter bAdapter;
    ImageView back_img;
    CircleProgressView circleProgressView;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.salon_at_home), Integer.valueOf(R.drawable.salon_at_home), Integer.valueOf(R.drawable.salon_at_home), Integer.valueOf(R.drawable.salon_at_home), Integer.valueOf(R.drawable.salon_at_home)};
    private RecyclerView recyclerView;
    ImageView search;
    TextView title;
    private String[] title1 = {"Very Nice Service!", "Will Use it Again", "Very Nice Service!", "Will Use it Again", "Very Nice Service!"};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_review_rating);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ReviewRatingActivity.this.onBackPressed();
            }
        });
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Rating & Reviews");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("20"));
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title1[i]));
        }
        this.bAdapter = new ReviewRatingRecycleAdapter(this, this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
    }
}
