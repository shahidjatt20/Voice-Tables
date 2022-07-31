package com.Teconz.voicetables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.Teconz.voicetables.Ads.AdmobHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mix extends AppCompatActivity {
    TextView number1,number2,addi,optn1,optn2,optn3,optn4,qustion;
    com.Teconz.voicetables.mdlmix mdlmix;
    List<mdlmix> modelList;
    Random random;
    int postion;
    int question=1;
    int correct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix);
        addition();
        AdmobHelper.loadAdaptiveBannerAd(this);
        modelList=new ArrayList<>();
        add_data();
        random=new Random();
        postion= random.nextInt(modelList.size());
        settext(postion);
        optn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext=optn1.getText().toString();
                Log.e("info","getdatafromtxt"+gettext);
                Log.e("info","correct answer"+modelList.get(postion).getResult());
                String result=String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)){
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);

                }
                else{
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext=optn2.getText().toString();
                Log.e("info","getdatafromtxt"+gettext);
                Log.e("info","correct answer"+modelList.get(postion).getResult());
                String result=String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)){
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                }
                else{
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext=optn3.getText().toString();
                Log.e("info","getdatafromtxt"+gettext);
                Log.e("info","correct answer"+modelList.get(postion).getResult());
                String result=String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)){
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                }
                else{
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext=optn4.getText().toString();
                Log.e("info","getdatafromtxt"+gettext);
                Log.e("info","correct answer"+modelList.get(postion).getResult());
                String result=String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)){
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                }
                else{
                    Toast.makeText(mix.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random=new Random();
                    postion= random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
    }
    void addition(){
        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        addi=findViewById(R.id.addi);
        optn1=findViewById(R.id.optn1);
        optn2=findViewById(R.id.optn2);
        optn3=findViewById(R.id.optn3);
        optn4=findViewById(R.id.optn4);
        qustion=findViewById(R.id.qustion);
    }

    void add_data(){
        modelList.add(mdlmix=new mdlmix(14,21,"+",35,51,43,35,49));
        modelList.add(mdlmix=new mdlmix(65, 66, "+",131, 68, 131, 170, 71));
        modelList.add(mdlmix=new mdlmix( 68, 69,"+", 137, 137, 72, 173, 74));
        modelList.add(mdlmix=new mdlmix(69, 24,"+", 93,93, 66, 89,42));
        modelList.add(mdlmix=new mdlmix(19,80,"+",99,44,99,100,109));
        modelList.add(mdlmix=new mdlmix(15,21,"+",36,44,41,34,36));
        modelList.add(mdlmix=new mdlmix(74,35,"+",109,100,99,45,109));
        modelList.add(mdlmix=new mdlmix(21,34,"+",55,45,66,37,55));
        modelList.add(mdlmix=new mdlmix(22,43,"+",65,76,69,87,65));
        modelList.add(mdlmix=new mdlmix(27,25,"+",52,45,65,52,70));
        modelList.add(mdlmix=new mdlmix(61,21,"+",82,98,89,82,79));
        modelList.add(mdlmix=new mdlmix(50,42,"+",92,100,109,92,102));
        modelList.add(mdlmix=new mdlmix(43,22,"+",65,69,70,65,63));
        modelList.add(mdlmix=new mdlmix(23,34,"+",57,59,57,64,70));
        modelList.add(mdlmix=new mdlmix(34,21,"+",55,57,54,55,72));

        modelList.add(mdlmix=new mdlmix(14,7,"/",2,4,6,2,5));
        modelList.add(mdlmix=new mdlmix(16, 2, "/",3, 4, 3,8 , 7));
        modelList.add(mdlmix=new mdlmix( 18, 9,"/", 2, 6, 4, 7, 2));
        modelList.add(mdlmix=new mdlmix(27, 3, "/",9,3, 9, 7,4));
        modelList.add(mdlmix=new mdlmix(25,5,"/",5,8,10,5,9));
        modelList.add(mdlmix=new mdlmix(15,5,"/",3,9,4,3,6));
        modelList.add(mdlmix=new mdlmix(20,5,"/",4,10,2,4,9));
        modelList.add(mdlmix=new mdlmix(21,7,"/",3,5,6,3,9));
        modelList.add(mdlmix=new mdlmix(45,5,"/",9,7,9,4,6));
        modelList.add(mdlmix=new mdlmix(27,9,"/",3,4,6,3,7));
        modelList.add(mdlmix=new mdlmix(42,7,"/",6,4,8,5,6));
        modelList.add(mdlmix=new mdlmix(50,5,"/",10,10,9,5,7));
        modelList.add(mdlmix=new mdlmix(60,12,"/",5,9,6,5,10));
        modelList.add(mdlmix=new mdlmix(48,8,"/",6,5,7,4,6));

        modelList.add(mdlmix=new mdlmix(4,2,"X",8,7,8,10,9));
        modelList.add(mdlmix=new mdlmix(6, 2,"X", 18, 20, 18, 17, 10));
        modelList.add(mdlmix=new mdlmix( 6, 6, "X",36, 37, 30, 36, 23));
        modelList.add(mdlmix=new mdlmix(6, 4,"X", 24,21, 25, 27,24));
        modelList.add(mdlmix=new mdlmix(3,3,"X",9,8,9,10,6));
        modelList.add(mdlmix=new mdlmix(3,7,"X",21,24,21,34,36));
        modelList.add(mdlmix=new mdlmix(7,5,"X",35,39,24,35,49));
        modelList.add(mdlmix=new mdlmix(2,8,"X",16,15,26,16,21));
        modelList.add(mdlmix=new mdlmix(8,4,"X",32,42,31,32,36));
        modelList.add(mdlmix=new mdlmix(2,5,"X",10,15,21,12,10));
        modelList.add(mdlmix=new mdlmix(6,7,"X",42,54,34,42,60));
        modelList.add(mdlmix=new mdlmix(3,4,"X",12,10,29,12,19));
        modelList.add(mdlmix=new mdlmix(9,6,"X",54,61,54,56,63));
        modelList.add(mdlmix=new mdlmix(2,3,"X",6,9,5,6,7));

        modelList.add(mdlmix=new mdlmix(14,21,"-",7,5,7,9,10));
        modelList.add(mdlmix=new mdlmix(67, 47, "-",20, 16, 20, 13, 12));
        modelList.add(mdlmix=new mdlmix( 70, 53, "-",17, 17, 12, 18, 14));
        modelList.add(mdlmix=new mdlmix(69, 24, "-",45,45, 66, 40,42));
        modelList.add(mdlmix=new mdlmix(89,80,"-",9,8,9,10,11));
        modelList.add(mdlmix=new mdlmix(21,15,"-",6,4,7,9,6));
        modelList.add(mdlmix=new mdlmix(74,35,"-",39,40,35,45,39));
        modelList.add(mdlmix=new mdlmix(45,34,"-",11,22,14,11,10));
        modelList.add(mdlmix=new mdlmix(52,43,"-",9,7,9,8,5));
        modelList.add(mdlmix=new mdlmix(27,25,"-",2,4,5,2,1));
        modelList.add(mdlmix=new mdlmix(61,21,"-",40,38,46,40,49));
        modelList.add(mdlmix=new mdlmix(50,42,"-",8,8,9,10,12));
        modelList.add(mdlmix=new mdlmix(43,22,"-",21,19,21,15,13));
        modelList.add(mdlmix=new mdlmix(43,30,"-",13,20,17,13,1));


    }
    void settext(int position){
        if (question==11){
            Intent resultactivity=new Intent(mix.this,result.class);
            finish();
            AdmobHelper.showAdmobInterstitial(mix.this);
            resultactivity.putExtra("res",correct);
            startActivity(resultactivity);
        }
        else {
            qustion.setText("Q :"+question+"/10");
            number1.setText(String.valueOf(modelList.get(position).getNumber1()));
            number2.setText(String.valueOf(modelList.get(position).getNumber2()));
            addi.setText(String.valueOf(modelList.get(position).getAddi()));
            optn1.setText(String.valueOf(modelList.get(position).getOption1()));
            optn2.setText(String.valueOf(modelList.get(position).getOption2()));
            optn3.setText(String.valueOf(modelList.get(position).getOption3()));
            optn4.setText(String.valueOf(modelList.get(position).getOption4()));
        }
    }
}