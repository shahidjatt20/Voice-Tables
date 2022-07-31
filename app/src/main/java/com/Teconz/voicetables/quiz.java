package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Teconz.voicetables.Ads.AdmobHelper;

public class quiz extends AppCompatActivity {
    TextView addition,subtraction,multiplication,division,mix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        FrameLayout frameLayout = findViewById(R.id.native_container);
        AdmobHelper.loadandshowAdmobNative(this,frameLayout);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(quiz.this, com.Teconz.voicetables.addition.class);
                AdmobHelper.showAdmobInterstitial(quiz.this);
                startActivity(intent);
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent subtraction=new Intent(quiz.this,subtraction.class);
                startActivity(subtraction);
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent multiplication=new Intent(quiz.this,multiplication.class);
                startActivity(multiplication);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(quiz.this, com.Teconz.voicetables.division.class);
                AdmobHelper.showAdmobInterstitial(quiz.this);
                startActivity(intent);
            }
        });
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mix=new Intent(quiz.this,mix.class);
                startActivity(mix);
            }
        });
    }
    void init(){
        addition=findViewById(R.id.addition);
        subtraction=findViewById(R.id.subtraction);
        multiplication=findViewById(R.id.multiplication);
        division=findViewById(R.id.division);
        mix=findViewById(R.id.mix);
    }
}