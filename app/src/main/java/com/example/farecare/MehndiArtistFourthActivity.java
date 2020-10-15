package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.CategorySubModelClass;
import com.example.farecare.adapter.BridalMakupFourSubRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistFourthActivity extends AppCompatActivity {

    /* renamed from: Adapter reason: collision with root package name */
    private BridalMakupFourSubRecycleAdapter Adapter;
    ImageView back_img;
    private ArrayList<CategorySubModelClass> categorySubModelClasses;
    CircleProgressView circleProgressView;
    int layout;
    LinearLayout linear;
    TextView number;
    TextView number1;
    private RecyclerView recyclerView1;
    ImageView search;
    TextView title;
    private String[] title2 = {"Erica", "Monika", "Erica", "Monika", "Erica", "Monika", "Erica", "Monika"};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mehndi_artist_fourth);
        this.title = (TextView) findViewById(R.id.title);
        this.layout = getIntent().getIntExtra("layout", 0);
        if (this.layout == 11) {
            this.title.setText("Mehendi Artist for Bride");
            this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
            this.circleProgressView.setVisibility(View.VISIBLE);
            this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setTextSize(20);
            this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
            this.circleProgressView.setValue(Float.parseFloat("50"));
        }
        if (this.layout == 22) {
            this.title.setText("Mehendi Artist for Bride & Guests");
        }
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistFourthActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MehndiArtistFourthActivity.this, MehndiArtistFourth_OneActivity.class);
                intent.putExtra("layout", MehndiArtistFourthActivity.this.layout);
                MehndiArtistFourthActivity.this.startActivity(intent);
            }
        });
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview_bridle);
        this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.categorySubModelClasses = new ArrayList<>();
        for (String categorySubModelClass : this.title2) {
            this.categorySubModelClasses.add(new CategorySubModelClass(categorySubModelClass));
        }
        this.Adapter = new BridalMakupFourSubRecycleAdapter(this, this.categorySubModelClasses);
        this.recyclerView1.setAdapter(this.Adapter);
    }
}

