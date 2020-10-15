package com.example.farecare.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.farecare.R;
import com.example.farecare.adapter.CategoryPagerAdapterBooking;
import com.google.android.material.tabs.TabLayout;

public class BookingFragment extends Fragment {
    private TabLayout tabLayout;
    private int tab_value;
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_booking, viewGroup, false);
        this.tabLayout = (TabLayout) this.view.findViewById(R.id.tab_layout);
        this.tabLayout.setTabMode(TabLayout.MODE_FIXED);
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "ON GOING"));
        this.tabLayout.addTab(this.tabLayout.newTab().setText((CharSequence) "HISTORY"));
        Typeface createFromAsset = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        ViewGroup viewGroup2 = (ViewGroup) this.tabLayout.getChildAt(0);
        int childCount = viewGroup2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getChildAt(i);
            int childCount2 = viewGroup3.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt = viewGroup3.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTypeface(createFromAsset, Typeface.NORMAL);
                }
            }
        }
        this.tabLayout.setTabGravity(0);
        final ViewPager viewPager = (ViewPager) this.view.findViewById(R.id.pager);
        viewPager.setAdapter(new CategoryPagerAdapterBooking(getChildFragmentManager(), 2));
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
        return this.view;
    }
}
