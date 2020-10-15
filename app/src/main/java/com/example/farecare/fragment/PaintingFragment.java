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
import com.example.farecare.adapter.PaintingRecycleAdapter;

import java.util.ArrayList;

public class PaintingFragment extends Fragment {
    private PaintingRecycleAdapter bAdapter;
    private ArrayList<HomeCategoryModelClass> homeCategoryModelClasses;
    private Integer[] image = {Integer.valueOf(R.drawable.home_painting), Integer.valueOf(R.drawable.office_painting)};
    private RecyclerView recyclerView;
    private String[] title = {"Home Painting", "Office Painting"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_painting, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.homeCategoryModelClasses = new ArrayList<>();
        for (int i = 0; i < this.image.length; i++) {
            this.homeCategoryModelClasses.add(new HomeCategoryModelClass(this.image[i], this.title[i]));
        }
        this.bAdapter = new PaintingRecycleAdapter(getActivity(), this.homeCategoryModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}

