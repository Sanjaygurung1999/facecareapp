package com.example.farecare;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.WeddingModelClass;
import com.example.farecare.adapter.WeddingRecycleAdapter;

import java.util.ArrayList;

public class MakupAndHairActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: Adapter reason: collision with root package name */
    private WeddingRecycleAdapter Adapter;
    ImageView back_img;
    LinearLayout bridallinear;
    Button button;

    /* renamed from: i */
    int i = 0;
    ImageView image1;
    ImageView image2;
    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linearmain1;
    LinearLayout linearmain2;
    TextView number;
    TextView number1;
    private RecyclerView recyclerView1;
    ImageView search;
    /* access modifiers changed from: private */
    private boolean selected1 = true;
    /* access modifiers changed from: private */
    private boolean selected2;
    TextView title;
    TextView title1;
    TextView title2;
    private String[] title3 = {"Subtle makeup + Free Hairstyling", "Detailed Makeup + Free Hairstyling", "Only Hairstyling + Free Draping", "Makeup & Hairstyling for Photoshoot"};
    private String[] txt1 = {"-$30 per person", "-$50 per person", "-$20 per person", "-$60 per person"};
    private String[] txt2 = {"-Complete Professional Makeup", "-Smokey eyes + Flase lashes", "- Hair: straightening, Blow-dry,\n  Curls, Buns, Braids", "- Multiple looks for the entire shoot"};
    private String[] txt3 = {"- Hair: straightening, Blow-dry,\n  Curls, Buns, Braids", "- Hair: straightening, Blow-dry,\n  Curls, Buns, Braids", "", ""};
    private ArrayList<WeddingModelClass> weddingModelClasses;
    LinearLayout weddinglinear;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_makup_and_hair);
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Makeup & Hair Styling");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakupAndHairActivity.this.onBackPressed();
            }
        });
        this.button = (Button) findViewById(R.id.button);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linearmain1 = (LinearLayout) findViewById(R.id.linearmain1);
        this.linearmain2 = (LinearLayout) findViewById(R.id.linearmain2);
        this.image1 = (ImageView) findViewById(R.id.image1);
        this.image2 = (ImageView) findViewById(R.id.image2);
        this.title1 = (TextView) findViewById(R.id.title1);
        this.title2 = (TextView) findViewById(R.id.title2);
        this.bridallinear = (LinearLayout) findViewById(R.id.bridallinear);
        this.weddinglinear = (LinearLayout) findViewById(R.id.weddinglinear);
        this.linearmain1.setOnClickListener(this);
        this.linearmain2.setOnClickListener(this);
        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MakupAndHairActivity.this.selected1) {
                    MakupAndHairActivity.this.startActivity(new Intent(MakupAndHairActivity.this, MakupAndHairFirstActivity.class));
                } else if (MakupAndHairActivity.this.selected2) {
                    MakupAndHairActivity.this.startActivity(new Intent(MakupAndHairActivity.this, WeddingPartyOneActivity.class));
                }
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearmain1 /*2131361959*/:
                this.linear1.setBackgroundResource(R.drawable.bridel_rect);
                this.title1.setTextColor(Color.parseColor("#38393f"));
                this.linear2.setBackgroundResource(R.drawable.light_bridel_rect);
                this.title2.setTextColor(Color.parseColor("#5a5b65"));
                this.bridallinear.setVisibility(View.VISIBLE);
                this.weddinglinear.setVisibility(View.GONE);
                this.selected1 = true;
                return;
            case R.id.linearmain2 /*2131361960*/:
                this.linear1.setBackgroundResource(R.drawable.light_bridel_rect);
                this.title1.setTextColor(Color.parseColor("#5a5b65"));
                this.linear2.setBackgroundResource(R.drawable.bridel_rect);
                this.title2.setTextColor(Color.parseColor("#38393f"));
                this.bridallinear.setVisibility(View.GONE);
                this.weddinglinear.setVisibility(View.VISIBLE);
                this.selected2 = true;
                this.selected1 = false;
                this.recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview);
                this.recyclerView1.setLayoutManager(new LinearLayoutManager(this));
                this.recyclerView1.setItemAnimator(new DefaultItemAnimator());
                this.weddingModelClasses = new ArrayList<>();
                for (int i = 0; i < this.title3.length; i++) {
                    this.weddingModelClasses.add(new WeddingModelClass(this.title3[i], this.txt1[i], this.txt2[i], this.txt3[i]));
                }
                this.Adapter = new WeddingRecycleAdapter(this, this.weddingModelClasses);
                this.recyclerView1.setAdapter(this.Adapter);
                return;
            default:
                return;
        }
    }
}
