package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.MehndiArtistOneModelClass;
import com.example.farecare.adapter.MehndiArtistOneRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class MehndiArtistBrideGusestActivity extends AppCompatActivity {

    /* renamed from: Adapter reason: collision with root package name */
    private MehndiArtistOneRecycleAdapter Adapter;
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    private ArrayList<MehndiArtistOneModelClass> mehndiArtistOneModelClasses;
    TextView number;
    TextView number1;
    private RecyclerView recyclerView1;
    ImageView search;
    private String[] subtitle = {"$15 to $20", "$20 to $30", "$50 to $70"};
    TextView title;
    private String[] title2 = {"Traditional Design", "Theme Design", "Premium Finish Design"};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_mehndi_artist_bride_gusest);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("20"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Mehendi Artist for Bride & Guests");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistBrideGusestActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistBrideGusestActivity.this.startActivity(new Intent(MehndiArtistBrideGusestActivity.this, MehndiArtistBrideGuestThreeActivity.class));
            }
        });
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview);
        this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.mehndiArtistOneModelClasses = new ArrayList<>();
        for (int i = 0; i < this.title2.length; i++) {
            this.mehndiArtistOneModelClasses.add(new MehndiArtistOneModelClass(this.title2[i], this.subtitle[i]));
        }
        this.Adapter = new MehndiArtistOneRecycleAdapter(this, this.mehndiArtistOneModelClasses);
        this.recyclerView1.setAdapter(this.Adapter);
    }
}
