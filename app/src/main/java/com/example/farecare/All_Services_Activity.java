package com.example.farecare;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.farecare.adapter.CategoryPagerAdapterAllServices;
import com.google.android.material.tabs.TabLayout;

public class All_Services_Activity extends AppCompatActivity {
    ImageView back_img;
    private TabLayout tabLayout;
    private int tab_value;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView((int)R.layout.activity_all__services_);
        this.back_img=(ImageView) findViewById(R.id.back_img);
        this.back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                All_Services_Activity.this.onBackPressed();
            }
        });
        this.tab_value=getIntent().getIntExtra("layout",0);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.actionbar_color));
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.actionbar_color));
        }
        this.tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        this.tabLayout.setTabMode(tabLayout.MODE_SCROLLABLE);
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Beauty"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Appliance Repair"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Home Cleaning"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Wedding & Events"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Paintings"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Pest Control"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Moving Homes"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Plumber"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "Electrician"));
        Typeface createFromAsset = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        ViewGroup viewGroup = (ViewGroup) this.tabLayout.getChildAt(0);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(i);
            int childCount2 = viewGroup2.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt = viewGroup2.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(createFromAsset, Typeface.NORMAL);
                }
            }
        }
        this.tabLayout.setTabGravity(0);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new CategoryPagerAdapterAllServices(getSupportFragmentManager(), 9));
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        if (this.tab_value >= 0) {
            this.tabLayout.setScrollPosition(this.tab_value, 0.0f, true);
            viewPager.setCurrentItem(this.tab_value);
        }
        this.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }
}
