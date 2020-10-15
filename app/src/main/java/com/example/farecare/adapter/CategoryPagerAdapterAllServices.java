package com.example.farecare.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.farecare.fragment.BeautyFragment;
import com.example.farecare.fragment.ApplianceRepairFragment;
import com.example.farecare.fragment.HomeCleaningFragment;
import com.example.farecare.fragment.WeddingEventsFragment;
import com.example.farecare.fragment.PaintingFragment;
import com.example.farecare.fragment.PestControlFragment;
import com.example.farecare.fragment.MovingHomeFragment;
import com.example.farecare.fragment.PlumberFragment;
import com.example.farecare.fragment.ElectricianFragment;

public class CategoryPagerAdapterAllServices extends FragmentPagerAdapter {
    int mNoOfTabs;

    public CategoryPagerAdapterAllServices(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.mNoOfTabs = i;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new BeautyFragment();
            case 1:
                return new ApplianceRepairFragment();
            case 2:
                return new HomeCleaningFragment();
            case 3:
                return new WeddingEventsFragment();
            case 4:
                return new PaintingFragment();
            case 5:
                return new PestControlFragment();
            case 6:
                return new MovingHomeFragment();
            case 7:
                return new PlumberFragment();
            case 8:
                return new ElectricianFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return this.mNoOfTabs;
    }
}

