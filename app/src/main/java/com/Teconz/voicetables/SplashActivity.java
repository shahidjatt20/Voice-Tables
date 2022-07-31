package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.Teconz.voicetables.Ads.AdmobHelper;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AdmobHelper.iniSDk(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main= new Intent(SplashActivity.this,main.class);
                startActivity(main);
                finish();
            }
        },5000);
    }
}