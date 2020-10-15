package com.example.farecare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.farecare.ModelClass.MehndiArtistOneModelClass;
import com.example.farecare.R;

import java.util.List;

public class MehndiArtistOneRecycleAdapter extends Adapter<MehndiArtistOneRecycleAdapter.MyViewHolder> {
    private List<MehndiArtistOneModelClass> OfferList;
    Context context;
    int myPos = 0;

    public class MyViewHolder extends ViewHolder {
        TextView subtitle;
        RadioButton title;

        public MyViewHolder(View view) {
            super(view);
            this.title = (RadioButton) view.findViewById(R.id.title);
            this.subtitle = (TextView) view.findViewById(R.id.subtitle);
        }
    }

    public MehndiArtistOneRecycleAdapter(Context context2, List<MehndiArtistOneModelClass> list) {
        this.OfferList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mehndi_artist_list, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        MehndiArtistOneModelClass mehndiArtistOneModelClass = (MehndiArtistOneModelClass) this.OfferList.get(i);
        myViewHolder.title.setText(mehndiArtistOneModelClass.getTitle());
        myViewHolder.subtitle.setText(mehndiArtistOneModelClass.getSubtitle());
        if (this.myPos == i) {
            myViewHolder.title.setSelected(true);
        } else {
            myViewHolder.title.setSelected(false);
        }
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MehndiArtistOneRecycleAdapter.this.myPos = i;
                MehndiArtistOneRecycleAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public int getItemCount() {
        return this.OfferList.size();
    }
}
