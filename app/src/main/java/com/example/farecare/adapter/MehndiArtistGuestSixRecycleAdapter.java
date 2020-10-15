package com.example.farecare.adapter;

import android.content.Context;
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

import java.util.List;

public class MehndiArtistGuestSixRecycleAdapter extends Adapter<MehndiArtistGuestSixRecycleAdapter.MyViewHolder> {
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

    public MehndiArtistGuestSixRecycleAdapter(Context context2, List<CategorySubModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mehndi_artist_guest_six_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(((CategorySubModelClass) this.OfferList.get(i)).getTitle());
        myViewHolder.linear_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myViewHolder.linear_count.setVisibility(View.VISIBLE);
                myViewHolder.linear_add.setVisibility(View.GONE);
                myViewHolder.number.setText(String.valueOf(MehndiArtistGuestSixRecycleAdapter.this.count));
            }
        });
        myViewHolder.plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistGuestSixRecycleAdapter.this.count = MehndiArtistGuestSixRecycleAdapter.this.count + 1;
                myViewHolder.number.setText(String.valueOf(MehndiArtistGuestSixRecycleAdapter.this.count));
            }
        });
        myViewHolder.minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistGuestSixRecycleAdapter.this.count = MehndiArtistGuestSixRecycleAdapter.this.count - 1;
                if (MehndiArtistGuestSixRecycleAdapter.this.count >= 0) {
                    myViewHolder.number.setText(String.valueOf(MehndiArtistGuestSixRecycleAdapter.this.count));
                }
                if (MehndiArtistGuestSixRecycleAdapter.this.count == 0) {
                    myViewHolder.linear_count.setVisibility(View.GONE);
                    myViewHolder.linear_add.setVisibility(View.VISIBLE);
                    MehndiArtistGuestSixRecycleAdapter.this.count = 1;
                }
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
