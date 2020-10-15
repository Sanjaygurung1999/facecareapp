package com.example.farecare.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.farecare.MakupAndHairActivity;
import com.example.farecare.ModelClass.Team;
import com.example.farecare.R;
import com.example.farecare.SalonAtHomeWomenOne;

import java.util.ArrayList;

public class CustomAdapter extends BaseExpandableListAdapter {
    /* access modifiers changed from: private */

    /* renamed from: c */
    private Context c;
    private int groupPosition;
    private LayoutInflater inflater;
    private ArrayList<Team> team;

    public long getChildId(int i, int i2) {
        return 0;
    }

    public long getGroupId(int i) {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public CustomAdapter(Context context, ArrayList<Team> arrayList) {
        this.c = context;
        this.team = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Object getChild(int i, int i2) {
        return ((Team) this.team.get(i)).players.get(i2);
    }

    public View getChildView(int i, final int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.item_group_header, null);
        }
        String str = (String) getChild(i, i2);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
        ((TextView) view.findViewById(R.id.textView1)).setText(str);
        String obj = getGroup(i).toString();
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (i2 == 0) {
                    CustomAdapter.this.c.startActivity(new Intent(CustomAdapter.this.c, SalonAtHomeWomenOne.class));
                } else if (i2 == 1) {
                    CustomAdapter.this.c.startActivity(new Intent(CustomAdapter.this.c, MakupAndHairActivity.class));
                }
            }
        });
        if (obj.equals("Salon at home for Women")) {
            if (str == "Regular Waxing") {
                imageView.setImageResource(R.drawable.waxing);
            } else if (str == "Facial") {
                imageView.setImageResource(R.drawable.facial);
            } else if (str == "Pedicure & Manicure") {
                imageView.setImageResource(R.drawable.pedicure);
            } else if (str == "Hair") {
                imageView.setImageResource(R.drawable.pedicure);
            } else if (str == "Threading") {
                imageView.setImageResource(R.drawable.threading);
            }
        }
        return view;
    }

    public int getChildrenCount(int i) {
        return ((Team) this.team.get(i)).players.size();
    }

    public Object getGroup(int i) {
        return this.team.get(i);
    }

    public int getGroupCount() {
        return this.team.size();
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.team, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.headerlayout);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear);
        String str = ((Team) getGroup(i)).Name;
        textView.setText(str);
        if (i == 0) {
            linearLayout2.setVisibility(View.VISIBLE);
        } else if (i == 1) {
            linearLayout2.setVisibility(View.VISIBLE);
        }
        if (str == "Salon at home for Women") {
            imageView.setImageResource(R.drawable.salon_at_home);
        } else if (str == "Makeup & Hair Styling") {
            imageView.setImageResource(R.drawable.makeup);
        }
        view.setBackgroundColor(-3355444);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.arrow);
        if (z) {
            imageView2.setImageResource(R.drawable.ic_up_arrow);
        } else {
            imageView2.setImageResource(R.drawable.ic_down_arrow5);
        }
        return view;
    }
}
