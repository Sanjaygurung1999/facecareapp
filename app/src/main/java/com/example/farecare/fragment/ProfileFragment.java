package com.example.farecare.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.R;
import com.example.farecare.adapter.ProfileRecycleAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private ProfileRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.ic_notifications), Integer.valueOf(R.drawable.ic_booking), Integer.valueOf(R.drawable.ic_manage_address), Integer.valueOf(R.drawable.ic_help), Integer.valueOf(R.drawable.ic_rate_us), Integer.valueOf(R.drawable.ic_share), Integer.valueOf(R.drawable.ic_about), Integer.valueOf(R.drawable.ic_t_and_c)};
    private RecyclerView recyclerView;
    private String[] title = {"Notification", "My Bookings", "Manage Address", "Help", "Rate us", "Share App", "About Rapid", "Terms & Conditions"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new ProfileRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}
