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
import com.example.farecare.adapter.ElectricianRecycleAdapter;

import java.util.ArrayList;

public class ElectricianFragment extends Fragment {
    private ElectricianRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.fans), Integer.valueOf(R.drawable.lights), Integer.valueOf(R.drawable.inverter), Integer.valueOf(R.drawable.full_home_health_check1)};
    private RecyclerView recyclerView;
    private String[] title = {"Fan", "Lights", "Inverter", "Full Home Health Check"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_electrician, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new ElectricianRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}
