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

import com.example.farecare.BathRoomFittingOneActivity;
import com.example.farecare.BlocksLeakageOneActivity;
import com.example.farecare.FullHomeCheckPlumberOneActivity;
import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.R;
import com.example.farecare.ToiletSanitaryWorkOneActivity;
import com.example.farecare.WaterTankOneActivity;

import java.util.List;

public class PlumberRecycleAdapter extends Adapter<PlumberRecycleAdapter.MyViewHolder> {
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

    public PlumberRecycleAdapter(Context context2, List<HomeCategoryModelClass> list) {
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
                    PlumberRecycleAdapter.this.context.startActivity(new Intent(PlumberRecycleAdapter.this.context, BlocksLeakageOneActivity.class));
                } else if (i == 1) {
                    PlumberRecycleAdapter.this.context.startActivity(new Intent(PlumberRecycleAdapter.this.context, ToiletSanitaryWorkOneActivity.class));
                } else if (i == 2) {
                    PlumberRecycleAdapter.this.context.startActivity(new Intent(PlumberRecycleAdapter.this.context, BathRoomFittingOneActivity.class));
                } else if (i == 3) {
                    PlumberRecycleAdapter.this.context.startActivity(new Intent(PlumberRecycleAdapter.this.context, WaterTankOneActivity.class));
                } else if (i == 4) {
                    PlumberRecycleAdapter.this.context.startActivity(new Intent(PlumberRecycleAdapter.this.context, FullHomeCheckPlumberOneActivity.class));
                }
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
