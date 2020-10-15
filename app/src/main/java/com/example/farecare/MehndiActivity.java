package com.example.farecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.farecare.R;

    public class MehndiActivity extends AppCompatActivity {
        ImageView back_img;
        Button button;
        /* access modifiers changed from: private */

        /* renamed from: id */
        private int id;
        TextView number;
        TextView number1;
        RadioButton radio1;
        RadioButton radio2;
        RadioButton radio3;
        RadioButton radio4;
        RadioGroup radiogroup;
        ImageView search;
        TextView title;

        /* renamed from: v */
        private Object v;

        /* access modifiers changed from: protected */
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView((int) R.layout.activity_mehndi);
            this.radio1 = (RadioButton) findViewById(R.id.radio1);
            this.radio2 = (RadioButton) findViewById(R.id.radio2);
            this.radio3 = (RadioButton) findViewById(R.id.radio3);
            this.radio4 = (RadioButton) findViewById(R.id.radio4);
            this.radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
            this.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    MehndiActivity.this.id = i;
                }
            });
            this.title = (TextView) findViewById(R.id.title);
            this.title.setText("Mehendi Artists");
            this.search = (ImageView) findViewById(R.id.search);
            this.search.setVisibility(View.GONE);
            this.back_img = (ImageView) findViewById(R.id.back_img);
            this.back_img.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MehndiActivity.this.onBackPressed();
                }
            });
            this.button = (Button) findViewById(R.id.button);
            this.button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    switch (MehndiActivity.this.id) {
                        case R.id.radio1 /*2131362010*/:
                            MehndiActivity.this.startActivity(new Intent(MehndiActivity.this, MehndiArtistOneActivity.class));
                            return;
                        case R.id.radio2 /*2131362011*/:
                            MehndiActivity.this.startActivity(new Intent(MehndiActivity.this, MehndiArtistBrideActivity.class));
                            return;
                        case R.id.radio3 /*2131362012*/:
                        case R.id.radio4 /*2131362013*/:
                            return;
                        default:
                            Toast.makeText(MehndiActivity.this, "Please select anyone item", Toast.LENGTH_SHORT).show();
                            return;
                    }
                }
            });
        }
    }

