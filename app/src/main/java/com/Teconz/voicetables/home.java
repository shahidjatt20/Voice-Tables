package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Teconz.voicetables.Ads.AdmobHelper;

public class home extends AppCompatActivity {
    TextView n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20;
    ImageView what;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        AdmobHelper.loadAdaptiveBannerAd(this);
        what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",1);
                startActivity(tableactivity);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",2);
                startActivity(tableactivity);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",3);
                startActivity(tableactivity);
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",4);
                startActivity(tableactivity);
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",5);
                startActivity(tableactivity);
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",6);
                startActivity(tableactivity);
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",7);
                startActivity(tableactivity);
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",8);
                startActivity(tableactivity);
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",9);
                startActivity(tableactivity);
            }
        });
        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",10);
                startActivity(tableactivity);
            }
        });n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",11);
                startActivity(tableactivity);
            }
        });n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",12);
                startActivity(tableactivity);
            }
        });n13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",13);
                startActivity(tableactivity);
            }
        });n14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",14);
                startActivity(tableactivity);
            }
        });n15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",15);
                startActivity(tableactivity);
            }
        });n16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",16);
                startActivity(tableactivity);
            }
        });n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",17);
                startActivity(tableactivity);
            }
        });n18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",18);
                startActivity(tableactivity);
            }
        });n19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",19);
                startActivity(tableactivity);
            }
        });n20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableactivity=new Intent(home.this,tables.class);
                tableactivity.putExtra("number",20);
                startActivity(tableactivity);
            }
        });


    }
    void init(){
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);
        n9=findViewById(R.id.n9);
        n10=findViewById(R.id.n10);
        n11=findViewById(R.id.n11);
        n12=findViewById(R.id.n12);
        n13=findViewById(R.id.n13);
        n14=findViewById(R.id.n14);
        n15=findViewById(R.id.n15);
        n16=findViewById(R.id.n16);
        n17=findViewById(R.id.n17);
        n18=findViewById(R.id.n18);
        n19=findViewById(R.id.n19);
        n20=findViewById(R.id.n20);
        what=findViewById(R.id.what);
    }
}