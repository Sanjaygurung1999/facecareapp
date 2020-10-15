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
import com.example.farecare.ModelClass.CategorySubModelClass;
import com.example.farecare.R;
import com.example.farecare.SalonAtHomeWomenTwo;

import java.util.List;

public class CategorySubRecycleAdapter extends Adapter<CategorySubRecycleAdapter.MyViewHolder> {
    private List<CategorySubModelClass> OfferList;
    Context context;
    /* access modifiers changed from: private */
    private int count = 1;

    public class MyViewHolder extends ViewHolder {
        LinearLayout linear_add;
        LinearLayout linear_count;
        ImageView minus;
        TextView number;
        ImageView plus;
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
            this.number = (TextView) view.findViewById(R.id.number);
            this.linear_add = (LinearLayout) view.findViewById(R.id.linear_add);
            this.linear_count = (LinearLayout) view.findViewById(R.id.linear_count);
            this.minus = (ImageView) view.findViewById(R.id.minus);
            this.plus = (ImageView) view.findViewById(R.id.plus);
        }
    }

    public CategorySubRecycleAdapter(Context context2, List<CategorySubModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category_sub_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(((CategorySubModelClass) this.OfferList.get(i)).getTitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CategorySubRecycleAdapter.this.context.startActivity(new Intent(CategorySubRecycleAdapter.this.context, SalonAtHomeWomenTwo.class));
            }
        });
        myViewHolder.linear_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myViewHolder.linear_count.setVisibility(View.VISIBLE);
                myViewHolder.linear_add.setVisibility(View.GONE);
                myViewHolder.number.setText(String.valueOf(CategorySubRecycleAdapter.this.count));
            }
        });
        myViewHolder.plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CategorySubRecycleAdapter.this.count = CategorySubRecycleAdapter.this.count + 1;
                myViewHolder.number.setText(String.valueOf(CategorySubRecycleAdapter.this.count));
            }
        });
        myViewHolder.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CategorySubRecycleAdapter.this.count = CategorySubRecycleAdapter.this.count - 1;
                if (CategorySubRecycleAdapter.this.count >= 0) {
                    myViewHolder.number.setText(String.valueOf(CategorySubRecycleAdapter.this.count));
                }
                if (CategorySubRecycleAdapter.this.count == 0) {
                    myViewHolder.linear_count.setVisibility(View.GONE);
                    myViewHolder.linear_add.setVisibility(View.VISIBLE);
                    CategorySubRecycleAdapter.this.count = 1;
                }
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
