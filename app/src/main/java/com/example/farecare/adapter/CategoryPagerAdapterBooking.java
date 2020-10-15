package com.example.farecare.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.farecare.fragment.OnGoingFragment;

public class CategoryPagerAdapterBooking extends FragmentPagerAdapter {
    int mNoOfTabs;

    public CategoryPagerAdapterBooking(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.mNoOfTabs = i;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new OnGoingFragment();
            case 1:
                return new OnGoingFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.mNoOfTabs;
    }
}

