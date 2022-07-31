package com.Teconz.voicetables;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Teconz.voicetables.Ads.AdmobHelper;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class main extends AppCompatActivity {
    TextView tet1, tet2;
    BottomSheetDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main();
        AdmobHelper.loadAdaptiveBannerAd(this);
        tet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main.this,home.class);
                AdmobHelper.showAdmobInterstitial(main.this);
                startActivity(intent);
            }
        });
        tet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizactivity=new Intent(main.this,quiz.class);
                startActivity(quizactivity);
            }
        });
    }

    void main() {
        tet1 = findViewById(R.id.tet1);
        tet2 = findViewById(R.id.tet2);
    }

    public void bottom_sheet_dialog() {
        Button button;
        dialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(main.this).inflate(R.layout.bottomlayout, null);
        button = view.findViewById(R.id.button);
        FrameLayout frameLayout = view.findViewById(R.id.native_container);
        AdmobHelper.loadandshowAdmobNative(this,frameLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdmobHelper.showAdmobInterstitial(main.this);
                setAlert();
            }
        });
        dialog.setContentView(view);
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        bottom_sheet_dialog();
    }

    public void setAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(main.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View view = LayoutInflater.from(this).inflate(R.layout.dialogbox, viewGroup, false);
        builder.setView(view);
        Button cancelbtn = view.findViewById(R.id.cncl);
        Button exitapp = view.findViewById(R.id.exit);
        RatingBar ratingBar = view.findViewById(R.id.rate);
        AlertDialog dialog = builder.create();
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        exitapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dialog.show();
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v < 5) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(main.this);
                    ViewGroup viewGroup = findViewById(android.R.id.content);
                    View view = LayoutInflater.from(main.this).inflate(R.layout.feedbck, viewGroup, false);
                    builder1.setView(view);
                    Button cnl = view.findViewById(R.id.cncel);
                    Button submit = view.findViewById(R.id.submit);
                    EditText enter=view.findViewById(R.id.enter);
                    AlertDialog dialog1 = builder1.create();
                    cnl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog1.dismiss();
                        }
                    });
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (enter.getText().toString().trim().equals("")){
                                submit.setEnabled(true);
                                Toast.makeText(main.this, "Please type feedback first", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                dialog1.dismiss();
                                Toast.makeText(main.this, "Thanks for your feedback", Toast.LENGTH_SHORT).show();
                            }
                            }
                    });
                    dialog1.show();
                    if (v==0){
                        submit.setEnabled(false);
                        dialog1.dismiss();
                    }
                } else {
                    openUrl();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }
            }

            private void openUrl() {
            }
        });
    }
}