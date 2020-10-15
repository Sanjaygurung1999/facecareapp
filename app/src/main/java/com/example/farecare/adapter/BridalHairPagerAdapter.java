package com.example.farecare.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.farecare.fragment.FirstImageFragment;

public class BridalHairPagerAdapter extends FragmentStatePagerAdapter {
    public int getCount() {
        return 3;
    }

    public BridalHairPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FirstImageFragment();
            case 1:
                return new FirstImageFragment();
            case 2:
                return new FirstImageFragment();
            default:
                return null;
        }
    }
}
