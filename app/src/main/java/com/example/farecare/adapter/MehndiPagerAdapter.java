package com.example.farecare.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.farecare.MehndiFirstFragment;

public class MehndiPagerAdapter extends FragmentStatePagerAdapter {
    public int getCount() {
        return 3;
    }

    public MehndiPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new MehndiFirstFragment();
            case 1:
                return new MehndiFirstFragment();
            case 2:
                return new MehndiFirstFragment();
            default:
                return null;
        }
    }
}
