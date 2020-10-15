package com.example.farecare.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;

import com.example.farecare.MehndiActivity;
import com.example.farecare.ModelClass.Team;
import com.example.farecare.R;
import com.example.farecare.adapter.CustomAdapter;

import java.util.ArrayList;

public class BeautyFragment extends Fragment {
    LinearLayout linear_mehndi;
    private View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(R.layout.fragment_beauty, viewGroup, false);
        this.linear_mehndi = (LinearLayout) this.view.findViewById(R.id.linear_mehndi);
        this.linear_mehndi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BeautyFragment.this.startActivity(new Intent(BeautyFragment.this.getActivity(), MehndiActivity.class));
            }
        });
        ExpandableListView expandableListView = (ExpandableListView) this.view.findViewById(R.id.expandblelistview);
        expandableListView.setBackgroundColor(-1);
        final ArrayList data = getData();
        expandableListView.setAdapter(new CustomAdapter(getActivity(), data));
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
                BeautyFragment.this.setListViewHeight(expandableListView, i);
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                Toast.makeText(BeautyFragment.this.getActivity().getApplicationContext(), (CharSequence) ((Team) data.get(i)).players.get(i2), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return this.view;
    }

    /* access modifiers changed from: private */
    private void setListViewHeight(ExpandableListView expandableListView, int i) {
        ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(expandableListView.getWidth(), View.MeasureSpec.EXACTLY);
        int i2 = 0;
        for (int i3 = 0; i3 < expandableListAdapter.getGroupCount(); i3++) {
            View groupView = expandableListAdapter.getGroupView(i3, false, null, expandableListView);
            groupView.measure(makeMeasureSpec, 0);
            i2 += groupView.getMeasuredHeight();
            if ((expandableListView.isGroupExpanded(i3) && i3 != i) || (!expandableListView.isGroupExpanded(i3) && i3 == i)) {
                int i4 = i2;
                for (int i5 = 0; i5 < expandableListAdapter.getChildrenCount(i3); i5++) {
                    View childView = expandableListAdapter.getChildView(i3, i5, false, null, expandableListView);
                    childView.measure(makeMeasureSpec, 0);
                    i4 += childView.getMeasuredHeight();
                }
                i2 = i4;
            }
        }
        ViewGroup.LayoutParams layoutParams = expandableListView.getLayoutParams();
        int dividerHeight = i2 + (expandableListView.getDividerHeight() * (expandableListAdapter.getGroupCount() - 1));
        if (dividerHeight < 10) {
            dividerHeight = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        }
        layoutParams.height = dividerHeight;
        expandableListView.setLayoutParams(layoutParams);
        expandableListView.requestLayout();
    }

    private ArrayList<Team> getData() {
        Team team = new Team("Salon at home for Women");
        team.players.add("Regular Waxing");
        team.players.add("Facial");
        team.players.add("Pedicure & Manicure");
        team.players.add("Hair");
        team.players.add("Threading");
        Team team2 = new Team("Makeup & Hair Styling");
        team2.players.add("Regular Waxing");
        team2.players.add("Facial");
        team2.players.add("Pedicure & Manicure");
        team2.players.add("Hair");
        team2.players.add("Threading");
        ArrayList<Team> arrayList = new ArrayList<>();
        arrayList.add(team);
        arrayList.add(team2);
        return arrayList;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view2, int i, int i2, long j) {
        view2.setBackgroundColor(-16776961);
        return false;
    }
}

