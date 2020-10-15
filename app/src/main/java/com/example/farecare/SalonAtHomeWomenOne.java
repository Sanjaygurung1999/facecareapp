package com.example.farecare;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.CategorySubModelClass;
import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.adapter.CategoryHorizontalRecycleAdapter;
import com.example.farecare.adapter.CategorySubRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class SalonAtHomeWomenOne extends AppCompatActivity {

    /* renamed from: Adapter reason: collision with root package name */
    private CategorySubRecycleAdapter Adapter;
    CardView CardReview;
    private CategoryHorizontalRecycleAdapter bAdapter;
    ImageView back_img;
    private ArrayList<CategorySubModelClass> categorySubModelClasses;
    ImageView circle;
    CircleProgressView circleProgressView;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.waxing), Integer.valueOf(R.drawable.facial), Integer.valueOf(R.drawable.pedicure), Integer.valueOf(R.drawable.mehendi), Integer.valueOf(R.drawable.threading)};
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    ImageView search;
    TextView title;
    private String[] title1 = {"Regular Waxing", "Facial", "Pedicure & Manicure", "Mehndi", "Threding"};
    private String[] title2 = {"Half Arm Waxing", "Leg Waxing"};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_salon_at_home_women_one);
        this.CardReview = (CardView) findViewById(R.id.CardReview);
        this.CardReview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SalonAtHomeWomenOne.this.startActivity(new Intent(SalonAtHomeWomenOne.this, ReviewRatingActivity.class));
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.actionbar_color));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar_color));
        }
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SalonAtHomeWomenOne.this.onBackPressed();
            }
        });
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Salon at home for women");
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("10"));
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setImageResource(R.drawable.ic_colorful_circle);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title1[i]));
        }
        this.bAdapter = new CategoryHorizontalRecycleAdapter(this, this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview_waxing);
        this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.categorySubModelClasses = new ArrayList<>();
        for (String categorySubModelClass : this.title2) {
            this.categorySubModelClasses.add(new CategorySubModelClass(categorySubModelClass));
        }
        this.Adapter = new CategorySubRecycleAdapter(this, this.categorySubModelClasses);
        this.recyclerView1.setAdapter(this.Adapter);
    }
}
