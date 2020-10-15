package com.example.farecare.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.farecare.EventPhotographerOneActivity;
import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.PartyDecorationOneActivity;
import com.example.farecare.R;
import com.example.farecare.WeddingPhotographerOneActivity;

import java.util.List;

public class WeddingEventRecycleAdapter extends Adapter<WeddingEventRecycleAdapter.MyViewHolder> {
    private List<HomeCategoryModelClass> OfferList;
    Context context;

    public class MyViewHolder extends ViewHolder {
        ImageView image;
        LinearLayout linear;
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.image);
            this.title = (TextView) view.findViewById(R.id.title);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    public WeddingEventRecycleAdapter(Context context2, List<HomeCategoryModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_appliance_repair_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        HomeCategoryModelClass homeCategoryModelClass = (HomeCategoryModelClass) this.OfferList.get(i);
        myViewHolder.image.setImageResource(homeCategoryModelClass.getImage().intValue());
        myViewHolder.title.setText(homeCategoryModelClass.getTitle());
        if (i == 4) {
            myViewHolder.linear.setVisibility(View.GONE);
        } else {
            myViewHolder.linear.setVisibility(View.VISIBLE);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (i == 0) {
                    WeddingEventRecycleAdapter.this.context.startActivity(new Intent(WeddingEventRecycleAdapter.this.context, PartyDecorationOneActivity.class));
                } else if (i == 1) {
                    WeddingEventRecycleAdapter.this.context.startActivity(new Intent(WeddingEventRecycleAdapter.this.context, WeddingPhotographerOneActivity.class));
                } else if (i == 2) {
                    WeddingEventRecycleAdapter.this.context.startActivity(new Intent(WeddingEventRecycleAdapter.this.context, EventPhotographerOneActivity.class));
                }
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}