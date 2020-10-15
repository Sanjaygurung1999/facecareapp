package com.example.farecare.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.farecare.LegWaxingFragment;

public class SubCategoryPagerAdapter extends FragmentStatePagerAdapter {
    public int getCount() {
        return 3;
    }

    public SubCategoryPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new LegWaxingFragment();
            case 1:
                return new LegWaxingFragment();
            case 2:
                return new LegWaxingFragment();
            default:
                return null;
        }
    }
}
