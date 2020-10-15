package com.example.farecare.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.example.farecare.ModelClass.DateDayModelClass;
import com.example.farecare.R;

import java.util.List;

public class DateDayRecycleAdapter extends Adapter<DateDayRecycleAdapter.MyViewHolder> {
    private List<DateDayModelClass> OfferList;
    Context context;
    int myPos = 0;
    boolean showingfirst = true;

    public class MyViewHolder extends ViewHolder {
        TextView date;
        TextView day;
        LinearLayout linear;

        public MyViewHolder(View view) {
            super(view);
            this.date = (TextView) view.findViewById(R.id.date);
            this.day = (TextView) view.findViewById(R.id.day);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    public DateDayRecycleAdapter(Context context2, List<DateDayModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dateday_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        DateDayModelClass dateDayModelClass = (DateDayModelClass) this.OfferList.get(i);
        myViewHolder.date.setText(dateDayModelClass.getDate());
        myViewHolder.day.setText(dateDayModelClass.getDay());
        if (this.myPos == i) {
            myViewHolder.date.setTextColor(Color.parseColor("#6685ff"));
            myViewHolder.day.setTextColor(Color.parseColor("#6685ff"));
            myViewHolder.linear.setBackgroundResource(R.drawable.blue_dateday_rect);
        } else {
            myViewHolder.date.setTextColor(Color.parseColor("#8f909e"));
            myViewHolder.day.setTextColor(Color.parseColor("#8f909e"));
            myViewHolder.linear.setBackgroundResource(R.drawable.gray_dateday_rect);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DateDayRecycleAdapter.this.myPos = i;
                DateDayRecycleAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
