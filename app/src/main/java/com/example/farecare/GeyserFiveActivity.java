package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.DateDayModelClass;
import com.example.farecare.adapter.DateDayRecycleAdapter;
import com.example.farecare.adapter.TimeRecycleAdapter;

import java.util.ArrayList;

import at.grabner.circleprogress.CircleProgressView;

public class GeyserFiveActivity extends AppCompatActivity {
    private DateDayRecycleAdapter bAdapter;
    private TimeRecycleAdapter bAdapter1;
    private TimeRecycleAdapter bAdapter2;
    private TimeRecycleAdapter bAdapter3;
    ImageView back_img;
    Button button;
    CircleProgressView circleProgressView;
    private String[] date = {"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
    private ArrayList<DateDayModelClass> dateDayModelClasses;
    private ArrayList<DateDayModelClass> dateDayModelClasses1;
    private ArrayList<DateDayModelClass> dateDayModelClasses2;
    private ArrayList<DateDayModelClass> dateDayModelClasses3;
    private String[] day = {"MON", "TUS", "WEN", "Thu", "FRI", "SAT", "SUN", "MON", "TUS", "WEN", "Thu", "FRI", "SAT", "SUN", "MON"};
    private String[] hours = {"am", "am", "am"};
    private String[] hours2 = {"pm", "pm", "pm", "pm", "pm"};
    private String[] hours3 = {"pm", "pm", "pm"};
    TextView number;
    TextView number1;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    ImageView search;
    private String[] time = {"09:00", "10:00", "11:00"};
    private String[] time2 = {"12:00", "01:00", "02:00", "03:00", "04:00"};
    private String[] time3 = {"06:00", "07:00", "08:00"};
    TextView title;

    public GeyserFiveActivity() {
    }

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_geyser_five);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("70"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Geyser");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GeyserFiveActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GeyserFiveActivity.this.startActivity(new Intent(GeyserFiveActivity.this, GeyserSixActivity.class));
            }
        });
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerview_date);
        new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.dateDayModelClasses = new ArrayList<>();
        for (int i = 0; i < this.date.length; i++) {
            this.dateDayModelClasses.add(new DateDayModelClass(this.date[i], this.day[i]));
        }
        this.bAdapter = new DateDayRecycleAdapter(this, this.dateDayModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview_morning);
        this.recyclerView1.setLayoutManager(new GridLayoutManager(this, 3));
        this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
        this.dateDayModelClasses1 = new ArrayList<>();
        for (int i2 = 0; i2 < this.time.length; i2++) {
            this.dateDayModelClasses1.add(new DateDayModelClass(this.time[i2], this.hours[i2]));
        }
        this.bAdapter1 = new TimeRecycleAdapter(this, this.dateDayModelClasses1);
        this.recyclerView1.setAdapter(this.bAdapter1);
        this.recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview_afternoon);
        this.recyclerView2.setLayoutManager(new GridLayoutManager(this, 3));
        this.recyclerView2.setItemAnimator(new DefaultItemAnimator());
        this.dateDayModelClasses2 = new ArrayList<>();
        for (int i3 = 0; i3 < this.time2.length; i3++) {
            this.dateDayModelClasses2.add(new DateDayModelClass(this.time2[i3], this.hours2[i3]));
        }
        this.bAdapter2 = new TimeRecycleAdapter(this, this.dateDayModelClasses2);
        this.recyclerView2.setAdapter(this.bAdapter2);
        this.recyclerView3 = (RecyclerView) findViewById(R.id.recyclerview_evening);
        this.recyclerView3.setLayoutManager(new GridLayoutManager(this, 3));
        this.recyclerView3.setItemAnimator(new DefaultItemAnimator());
        this.dateDayModelClasses3 = new ArrayList<>();
        for (int i4 = 0; i4 < this.time3.length; i4++) {
            this.dateDayModelClasses3.add(new DateDayModelClass(this.time3[i4], this.hours3[i4]));
        }
        this.bAdapter3 = new TimeRecycleAdapter(this, this.dateDayModelClasses3);
        this.recyclerView3.setAdapter(this.bAdapter3);
    }
}