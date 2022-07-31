package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class tables extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<Integer> userlist;
    myadapter myadapter;
    ImageView cancel,previous,next;
    int number,result;
    TextToSpeech mTTS;
    TextView table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        StartIoHelper.laodandshowBanner(this);
        Intent intent=getIntent();
        number=intent.getIntExtra("number",0);
        init();
        initdata();
        initRecyclerView();
        table.setText("Table : "+number);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(number==1){
                Toast.makeText(tables.this, "No more Tables Left",Toast.LENGTH_SHORT).show();
            }
            else {
                number=number-1;
                initRecyclerView();
            }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number>=20){
                    Toast.makeText(tables.this, "No more Tables Left",Toast.LENGTH_SHORT).show();
                }
                else {
                    number=number+1;
                    initRecyclerView();
                }
            }
        });



    }void init(){
        cancel=findViewById(R.id.cancel);
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.next);
    }
    private void initdata(){
        userlist=new ArrayList<>();
        userlist.add(1);
        userlist.add(2);
        userlist.add(3);
        userlist.add(4);
        userlist.add(5);
        userlist.add(6);
        userlist.add(7);
        userlist.add(8);
        userlist.add(9);
        userlist.add(10);
    }
    private void initRecyclerView() {
        table=findViewById(R.id.table);
        recyclerView=findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(androidx.recyclerview.widget.RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    result = mTTS.setLanguage(Locale.US);
                    Log.e("result",":result successfully recived");
                }else {
                    Toast.makeText(getApplicationContext(),"Voice feature not supported in your Device",Toast.LENGTH_LONG).show();
                }
            }
        });
        myadapter=new myadapter(userlist,this,String.valueOf(number),mTTS,result);
        recyclerView.setAdapter(myadapter);
        myadapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}