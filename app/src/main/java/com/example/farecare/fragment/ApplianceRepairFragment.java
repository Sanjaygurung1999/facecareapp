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
import com.example.farecare.adapter.ApplianceRepairRecycleAdapter;

import java.util.ArrayList;

public class ApplianceRepairFragment extends Fragment {
    private ApplianceRepairRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {R.drawable.geyser, R.drawable.ac, R.drawable.washing_machine, R.drawable.water_purifier, R.drawable.tv, R.drawable.microwave};
    private RecyclerView recyclerView;
    private String[] title = {"Geyser", "AC", "Washing Machine", "Water Purifier", "TV", "Microwave"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_appliance_repair, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new ApplianceRepairRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}