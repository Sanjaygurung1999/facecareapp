package com.example.farecare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.farecare.ModelClass.OffersModelClass;
import com.example.farecare.R;

import java.util.List;


public class OffersRecycleAdapter extends Adapter<OffersRecycleAdapter.MyViewHolder> {
    private List<OffersModelClass> OfferList;
    Context context;

    public class MyViewHolder extends ViewHolder {
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
        }
    }

    public OffersRecycleAdapter(Context context2, List<OffersModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_offers_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(((OffersModelClass) this.OfferList.get(i)).getTitle());
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
