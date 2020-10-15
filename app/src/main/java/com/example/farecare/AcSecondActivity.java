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

import com.example.farecare.ModelClass.AcSecondModelClass;
import com.example.farecare.adapter.AcSecondRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class AcSecondActivity extends AppCompatActivity {

    /* renamed from: Adapter reason: collision with root package name */
    private AcSecondRecycleAdapter Adapter;
    private ArrayList<AcSecondModelClass> acSecondModelClasses;
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    TextView number;
    TextView number1;
    private RecyclerView recyclerView1;
    ImageView search;
    private String[] subtitle = {"$20", "$30", "$25", "$20", "$35", " Price on inspection"};
    TextView title;
    private String[] title2 = {"Dry Service", "Wet Service", "Installation", "Gas Refill", "Uninstallation", "Repair"};

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_ac_second);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("25"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("AC");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AcSecondActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AcSecondActivity.this.startActivity(new Intent(AcSecondActivity.this, AcThirdActivity.class));
            }
        });
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview);
        this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.acSecondModelClasses = new ArrayList<>();
        for (int i = 0; i < this.title2.length; i++) {
            this.acSecondModelClasses.add(new AcSecondModelClass(this.title2[i], this.subtitle[i]));
        }
        this.Adapter = new AcSecondRecycleAdapter(this, this.acSecondModelClasses);
        this.recyclerView1.setAdapter(this.Adapter);
    }
}