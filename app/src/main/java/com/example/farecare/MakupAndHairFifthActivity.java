package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.farecare.adapter.BridalHairPagerAdapter;

import at.grabner.circleprogress.CircleProgressView;
import me.relex.circleindicator.CircleIndicator;

public class MakupAndHairFifthActivity extends AppCompatActivity {
    ImageView add;
    int adult = 1;
    ImageView back_img;
    LinearLayout bottom_linear;
    CircleProgressView circleProgressView;
    int count = 1;
    LinearLayout linear;
    LinearLayout linear_add;
    LinearLayout linear_count;
    ImageView minus;
    TextView number;
    TextView number1;
    ImageView search;
    private BridalHairPagerAdapter subCategoryPagerAdapter;
    TextView title;
    private ViewPager viewPager;

    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_makup_and_hair_fifth);
        this.circleProgressView = (CircleProgressView) findViewById(R.id.circleView);
        this.circleProgressView.setVisibility(View.VISIBLE);
        this.circleProgressView.setOuterContourColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setTextSize(20);
        this.circleProgressView.setBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setSpinBarColor(getResources().getColor(R.color.blue));
        this.circleProgressView.setValue(Float.parseFloat("62"));
        this.title = (TextView) findViewById(R.id.title);
        this.title.setText("Bridal Makeup Artist");
        this.search = (ImageView) findViewById(R.id.search);
        this.search.setVisibility(View.GONE);
        this.back_img = (ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakupAndHairFifthActivity.this.onBackPressed();
            }
        });
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MakupAndHairFifthActivity.this, MakupAndHairSixActivity.class);
                intent.putExtra("layout", 3);
                MakupAndHairFifthActivity.this.startActivity(intent);
            }
        });
        this.linear_add = (LinearLayout) findViewById(R.id.linear_add);
        this.linear_count = (LinearLayout) findViewById(R.id.linear_count);
        this.add = (ImageView) findViewById(R.id.plus);
        this.minus = (ImageView) findViewById(R.id.minus);
        this.number = (TextView) findViewById(R.id.number);
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MakupAndHairFifthActivity.this.count++;
                MakupAndHairFifthActivity.this.number.setText(String.valueOf(MakupAndHairFifthActivity.this.count));
            }
        });
        this.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MakupAndHairFifthActivity.this.count != 1) {
                    MakupAndHairFifthActivity.this.count--;
                    MakupAndHairFifthActivity.this.number.setText(String.valueOf(MakupAndHairFifthActivity.this.count));
                }
            }
        });
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        this.subCategoryPagerAdapter = new BridalHairPagerAdapter(getSupportFragmentManager());
        this.viewPager.setAdapter(this.subCategoryPagerAdapter);
        circleIndicator.setViewPager(this.viewPager);
        this.subCategoryPagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
            }
        });
    }
}
