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
import com.example.farecare.adapter.CategoryRecycleAdapter;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    private CategoryRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.ic_beauty), Integer.valueOf(R.drawable.ic_appliance), Integer.valueOf(R.drawable.ic_home_cleaning), Integer.valueOf(R.drawable.ic_wedding), Integer.valueOf(R.drawable.ic_painting), Integer.valueOf(R.drawable.ic_pest_control), Integer.valueOf(R.drawable.ic_movinghome), Integer.valueOf(R.drawable.ic_plumber), Integer.valueOf(R.drawable.ic_electrician)};
    private RecyclerView recyclerView;
    private String[] title = {"Beauty & Spa", "Appliance Repair", "Home Cleaning", "Weddings & Events", "Paintings", "Pest Control", "Moving Homes", "Plumber", "Electrician"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_category, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new CategoryRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}
