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
import com.example.farecare.adapter.HomeCleaningRecycleAdapter;

import java.util.ArrayList;

public class HomeCleaningFragment extends Fragment {
    private HomeCleaningRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.home_deep_cleaning), Integer.valueOf(R.drawable.kitchen_deep_cleaning), Integer.valueOf(R.drawable.carpet_cleaning), Integer.valueOf(R.drawable.bathroom_cleaning), Integer.valueOf(R.drawable.sofa_cleaning)};
    private RecyclerView recyclerView;
    private String[] title = {"Home Deep Cleaning", "Kitchen Deep Cleaning", "Carpet Cleaning", "Bathroom Cleaning", "Sofa Cleaning"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_home_cleaning, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new HomeCleaningRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}