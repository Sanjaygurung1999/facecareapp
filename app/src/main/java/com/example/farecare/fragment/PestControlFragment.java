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
import com.example.farecare.adapter.PestControlRecycleAdapter;

import java.util.ArrayList;

public class PestControlFragment extends Fragment {
    private PestControlRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.general_pest_control), Integer.valueOf(R.drawable.cockroach_control), Integer.valueOf(R.drawable.bed_bugs), Integer.valueOf(R.drawable.termite_control), Integer.valueOf(R.drawable.mosquito_control)};
    private RecyclerView recyclerView;
    private String[] title = {"General Pest Control", "Cockroach Control", "Bed Bugs Control", "Termite Control", "Mosquito Control"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_pest_control, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new PestControlRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}
