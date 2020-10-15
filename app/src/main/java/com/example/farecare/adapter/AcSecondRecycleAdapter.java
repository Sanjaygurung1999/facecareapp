package com.example.farecare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.farecare.ModelClass.AcSecondModelClass;
import com.example.farecare.R;

import java.util.List;

public class AcSecondRecycleAdapter extends Adapter<AcSecondRecycleAdapter.MyViewHolder> {
    private List<AcSecondModelClass> OfferList;
    Context context;

    public class MyViewHolder extends ViewHolder {
        LinearLayout linear;
        TextView subtitle;
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            this.subtitle = (TextView) view.findViewById(R.id.subtitle);
            this.title = (TextView) view.findViewById(R.id.title);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    public AcSecondRecycleAdapter(Context context2, List<AcSecondModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ac_second_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        AcSecondModelClass acSecondModelClass = (AcSecondModelClass) this.OfferList.get(i);
        myViewHolder.subtitle.setText(acSecondModelClass.getSubtitle());
        myViewHolder.title.setText(acSecondModelClass.getTitle());
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}