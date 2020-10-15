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
import com.example.farecare.adapter.MehndiArtistGuestSixRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistBrideGusestSixActivity extends AppCompatActivity {

    /* renamed from: Adapter reason: collision with root package name */
    private MehndiArtistGuestSixRecycleAdapter Adapter;
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
        setContentView((int) R.layout.activity_mehndi_artist_bride_gusest_six);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("60"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Mehendi Artist for Bride & Guests");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistBrideGusestSixActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MehndiArtistBrideGusestSixActivity.this, MehndiArtistFourth_OneActivity.class);
                intent.putExtra("layout", 33);
                MehndiArtistBrideGusestSixActivity.this.startActivity(intent);
            }
        });
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview_bridle);
        this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.categorySubModelClasses = new ArrayList<>();
        for (String categorySubModelClass : this.title2) {
            this.categorySubModelClasses.add(new CategorySubModelClass(categorySubModelClass));
        }
        this.Adapter = new MehndiArtistGuestSixRecycleAdapter(this, this.categorySubModelClasses);
        this.recyclerView1.setAdapter(this.Adapter);
    }
}

