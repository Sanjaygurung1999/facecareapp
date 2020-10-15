package com.example.farecare.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.farecare.BathroomCleaningOneActivity;
import com.example.farecare.CarpetCleaningOneActivity;
import com.example.farecare.HomeCleaningOneActivity;
import com.example.farecare.KitchenCleaningOneActivity;
import com.example.farecare.ModelClass.HomeCategoryModelClass;
import com.example.farecare.R;
import com.example.farecare.SofaCleaningOneActivity;

import java.util.List;

public class HomeCleaningRecycleAdapter extends Adapter<HomeCleaningRecycleAdapter.MyViewHolder> {
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

    public HomeCleaningRecycleAdapter(Context context2, List<HomeCategoryModelClass> list) {
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
                    Intent intent = new Intent(HomeCleaningRecycleAdapter.this.context, HomeCleaningOneActivity.class);
                    intent.putExtra("layout", 1);
                    HomeCleaningRecycleAdapter.this.context.startActivity(intent);
                } else if (i == 1) {
                    Intent intent2 = new Intent(HomeCleaningRecycleAdapter.this.context, KitchenCleaningOneActivity.class);
                    intent2.putExtra("layout", 2);
                    HomeCleaningRecycleAdapter.this.context.startActivity(intent2);
                } else if (i == 2) {
                    Intent intent3 = new Intent(HomeCleaningRecycleAdapter.this.context, CarpetCleaningOneActivity.class);
                    intent3.putExtra("layout", 3);
                    HomeCleaningRecycleAdapter.this.context.startActivity(intent3);
                } else if (i == 3) {
                    Intent intent4 = new Intent(HomeCleaningRecycleAdapter.this.context, BathroomCleaningOneActivity.class);
                    intent4.putExtra("layout", 4);
                    HomeCleaningRecycleAdapter.this.context.startActivity(intent4);
                } else if (i == 4) {
                    Intent intent5 = new Intent(HomeCleaningRecycleAdapter.this.context, SofaCleaningOneActivity.class);
                    intent5.putExtra("layout", 5);
                    HomeCleaningRecycleAdapter.this.context.startActivity(intent5);
                }
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
