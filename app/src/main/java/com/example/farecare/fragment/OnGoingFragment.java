package com.example.farecare.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farecare.ModelClass.BookingModelClass;
import com.example.farecare.R;
import com.example.farecare.adapter.BookingRecycleAdapter;

import java.util.ArrayList;

public class OnGoingFragment extends Fragment {
    private BookingRecycleAdapter bAdapter;
    private ArrayList<BookingModelClass> bookingModelClasses;
    private RecyclerView recyclerView;
    private String[] title = {"Salon at home for Women", "Massage for Men"};
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_on_going, viewGroup, false);
        this.recyclerView = (RecyclerView) this.view.findViewById(R.id.recyclerview);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.bookingModelClasses = new ArrayList<>();
        for (String bookingModelClass : this.title) {
            this.bookingModelClasses.add(new BookingModelClass(bookingModelClass));
        }
        this.bAdapter = new BookingRecycleAdapter(getActivity(), this.bookingModelClasses);
        this.recyclerView.setAdapter(this.bAdapter);
        return this.view;
    }
}