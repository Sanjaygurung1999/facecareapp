package com.example.farecare.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.example.farecare.ModelClass.WeddingModelClass;
import com.example.farecare.R;

import java.util.List;

public class WeddingRecycleAdapter extends Adapter<WeddingRecycleAdapter.MyViewHolder> {
    private List<WeddingModelClass> OfferList;
    Context context;
    int myPos = 0;

    public class MyViewHolder extends ViewHolder {
        LinearLayout linear;
        TextView title;
        TextView txt1;
        TextView txt2;
        TextView txt3;

        public MyViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
            this.txt1 = (TextView) view.findViewById(R.id.txt1);
            this.txt2 = (TextView) view.findViewById(R.id.txt2);
            this.txt3 = (TextView) view.findViewById(R.id.txt3);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    public WeddingRecycleAdapter(Context context2, List<WeddingModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wedding_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        WeddingModelClass weddingModelClass = (WeddingModelClass) this.OfferList.get(i);
        myViewHolder.title.setText(weddingModelClass.getTitle());
        myViewHolder.txt1.setText(weddingModelClass.getTxt1());
        myViewHolder.txt2.setText(weddingModelClass.getTxt2());
        myViewHolder.txt3.setText(weddingModelClass.getTxt3());
        if (i == 0) {
            myViewHolder.linear.setVisibility(View.VISIBLE);
        } else {
            myViewHolder.linear.setVisibility(View.GONE);
        }
        if (this.myPos == i) {
            myViewHolder.title.setTextColor(Color.parseColor("#5a5b65"));
        } else {
            myViewHolder.title.setTextColor(Color.parseColor("#5a5b65"));
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WeddingRecycleAdapter.this.myPos = i;
                WeddingRecycleAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
