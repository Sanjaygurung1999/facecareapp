package com.example.farecare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.farecare.ModelClass.BookingModelClass;
import com.example.farecare.R;

import java.util.List;

public class BookingRecycleAdapter extends Adapter<BookingRecycleAdapter.MyViewHolder> {
    private List<BookingModelClass> OfferList;
    Context context;
    int myPos = 0;
    boolean showingfirst = true;

    public class MyViewHolder extends ViewHolder {
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
        }
    }

    public BookingRecycleAdapter(Context context2, List<BookingModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_booking_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(((BookingModelClass) this.OfferList.get(i)).getTitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BookingRecycleAdapter.this.myPos = i;
                BookingRecycleAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}