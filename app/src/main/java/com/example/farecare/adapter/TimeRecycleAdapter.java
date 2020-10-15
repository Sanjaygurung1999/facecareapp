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

public class TimeRecycleAdapter extends Adapter<TimeRecycleAdapter.MyViewHolder> {
    private List<DateDayModelClass> OfferList;
    Context context;
    int myPos = 0;
    boolean showingfirst = true;

    public class MyViewHolder extends ViewHolder {
        TextView hours;
        LinearLayout linear;
        TextView time;

        public MyViewHolder(View view) {
            super(view);
            this.time = (TextView) view.findViewById(R.id.time);
            this.hours = (TextView) view.findViewById(R.id.hours);
            this.linear = (LinearLayout) view.findViewById(R.id.linear);
        }
    }

    public TimeRecycleAdapter(Context context2, List<DateDayModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_time_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        DateDayModelClass dateDayModelClass = (DateDayModelClass) this.OfferList.get(i);
        myViewHolder.time.setText(dateDayModelClass.getDate());
        myViewHolder.hours.setText(dateDayModelClass.getDay());
        if (this.myPos == i) {
            myViewHolder.time.setTextColor(Color.parseColor("#6685ff"));
            myViewHolder.hours.setTextColor(Color.parseColor("#6685ff"));
            myViewHolder.linear.setBackgroundResource(R.drawable.blue_dateday_rect);
        } else {
            myViewHolder.time.setTextColor(Color.parseColor("#8f909e"));
            myViewHolder.hours.setTextColor(Color.parseColor("#8f909e"));
            myViewHolder.linear.setBackgroundResource(R.drawable.gray_dateday_rect);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TimeRecycleAdapter.this.myPos = i;
                TimeRecycleAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
