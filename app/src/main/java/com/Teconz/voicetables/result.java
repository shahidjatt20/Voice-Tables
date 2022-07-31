package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Teconz.voicetables.Ads.AdmobHelper;

public class result extends AppCompatActivity {
    int correct;
    TextView restext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        FrameLayout frameLayout = findViewById(R.id.native_container);
        AdmobHelper.loadandshowAdmobNative(this,frameLayout);
        Intent intent=getIntent();
        correct=intent.getIntExtra("res",0);
        restext=findViewById(R.id.restext);
        restext.setText(String.valueOf(correct));
    }
}