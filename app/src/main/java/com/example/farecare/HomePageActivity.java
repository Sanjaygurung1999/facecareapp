package com.example.farecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.farecare.fragment.BookingFragment;
import com.example.farecare.fragment.CategoryFragment;
import com.example.farecare.fragment.HomeFragment;
import com.example.farecare.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

import java.lang.reflect.Field;

public class HomePageActivity extends AppCompatActivity {
    LinearLayout city_linear;
    FrameLayout frameLayout;
    LinearLayout linear;
    protected OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_cart /*2131361978*/:
                    HomePageActivity.this.city_linear.setVisibility(View.GONE);
                    HomePageActivity.this.title.setText("MyBooking");
                    HomePageActivity.this.loadFragment(new BookingFragment());
                    return true;
                case R.id.navigation_gifts /*2131361979*/:
                    HomePageActivity.this.city_linear.setVisibility(View.GONE);
                    HomePageActivity.this.title.setText("Category");
                    HomePageActivity.this.loadFragment(new CategoryFragment());
                    return true;
                case R.id.navigation_profile /*2131361981*/:
                    HomePageActivity.this.city_linear.setVisibility(View.GONE);
                    HomePageActivity.this.title.setText("Profile");
                    HomePageActivity.this.loadFragment(new ProfileFragment());
                    return true;
                case R.id.navigation_shop /*2131361982*/:
                    HomePageActivity.this.city_linear.setVisibility(View.GONE);
                    HomePageActivity.this.title.setText("Home");
                    HomePageActivity.this.loadFragment(new HomeFragment());
                    return true;
                default:
                    return false;
            }
        }
    };
    TextView title;


    public static class BottomNavigationViewHelper {
        @SuppressLint({"RestrictedApi"})
        public static void disableShiftMode(BottomNavigationView bottomNavigationView) {
            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
            try {
                Field declaredField = bottomNavigationMenuView.getClass().getDeclaredField("mShiftingMode");
                declaredField.setAccessible(true);
                declaredField.setBoolean(bottomNavigationMenuView, false);
                declaredField.setAccessible(false);
                for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
                    BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i);
                    bottomNavigationItemView.setShifting(false);
                    bottomNavigationItemView.setChecked(bottomNavigationItemView.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e2) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e2);
            }
        }
    }



    /* access modifiers changed from: protected */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_page);
        this.linear = (LinearLayout) findViewById(R.id.linear);
        this.linear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomePageActivity.this.startActivity(new Intent(HomePageActivity.this, LocationActivity.class));
            }
        });
        this.city_linear = (LinearLayout) findViewById(R.id.city_linear);
        this.title = (TextView) findViewById(R.id.title);
        loadFragment(new HomeFragment());
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
            View findViewById = bottomNavigationMenuView.getChildAt(i).findViewById(R.id.icon);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(1, 18.0f, displayMetrics);
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    private void loadFragment(Fragment fragment2) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.framelayout, fragment2);
        beginTransaction.commit();
    }
}