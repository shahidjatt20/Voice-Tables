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

public class division extends AppCompatActivity {
    TextView number1, number2, number3, optn1, optn2, optn3, optn4,qustion;
    model model;
    List<model> modelList;
    Random random;
    int postion;
    int question=1;
    int correct=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        AdmobHelper.loadAdaptiveBannerAd(this);
        addition();
        modelList = new ArrayList<>();
        add_data();
        random = new Random();
        postion = random.nextInt(modelList.size());
        settext(postion);
        optn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext = optn1.getText().toString();
                Log.e("info", "getdatafromtxt" + gettext);
                Log.e("info", "correct answer" + modelList.get(postion).getResult());
                String result = String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)) {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext = optn2.getText().toString();
                Log.e("info", "getdatafromtxt" + gettext);
                Log.e("info", "correct answer" + modelList.get(postion).getResult());
                String result = String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)) {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext = optn3.getText().toString();
                Log.e("info", "getdatafromtxt" + gettext);
                Log.e("info", "correct answer" + modelList.get(postion).getResult());
                String result = String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)) {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
        optn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gettext = optn4.getText().toString();
                Log.e("info", "getdatafromtxt" + gettext);
                Log.e("info", "correct answer" + modelList.get(postion).getResult());
                String result = String.valueOf(modelList.get(postion).getResult());
                if (gettext.equals(result)) {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(division.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    settext(postion);
                }
            }
        });
    }

    void addition() {
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        optn1 = findViewById(R.id.optn1);
        optn2 = findViewById(R.id.optn2);
        optn3 = findViewById(R.id.optn3);
        optn4 = findViewById(R.id.optn4);
        qustion=findViewById(R.id.qustion);
    }

    void add_data() {
        modelList.add(model = new model(14, 7, 2, 4, 6, 2, 5));
        modelList.add(model = new model(16, 2, 3, 4, 3, 8, 7));
        modelList.add(model = new model(18, 9, 2, 6, 4, 7, 2));
        modelList.add(model = new model(27, 3, 9, 3, 9, 7, 4));
        modelList.add(model = new model(25, 5, 5, 8, 10, 5, 9));
        modelList.add(model = new model(15, 5, 3, 9, 4, 3, 6));
        modelList.add(model = new model(20, 5, 4, 10, 2, 4, 9));
        modelList.add(model = new model(21, 7, 3, 5, 6, 3, 9));
        modelList.add(model = new model(45, 5, 9, 7, 9, 4, 6));
        modelList.add(model = new model(27, 9, 3, 4, 6, 3, 7));
        modelList.add(model = new model(42, 7, 6, 4, 8, 5, 6));
        modelList.add(model = new model(50, 5, 10, 10, 9, 5, 7));
        modelList.add(model = new model(60, 12, 5, 9, 6, 5, 10));
        modelList.add(model = new model(48, 8, 6, 5, 7, 4, 6));
        modelList.add(model = new model(30, 10, 3, 7, 6, 3, 5));
    }

    void settext(int position) {
        if (question == 11) {
            Intent resultactivity = new Intent(division.this, result.class);
            finish();
            AdmobHelper.showAdmobInterstitial(division.this);
            resultactivity.putExtra("res", correct);
            startActivity(resultactivity);
        } else {
            qustion.setText("Q :" + question + "/10");
            number1.setText(String.valueOf(modelList.get(position).getNumber1()));
            number2.setText(String.valueOf(modelList.get(position).getNumber2()));
            optn1.setText(String.valueOf(modelList.get(position).getOption1()));
            optn2.setText(String.valueOf(modelList.get(position).getOption2()));
            optn3.setText(String.valueOf(modelList.get(position).getOption3()));
            optn4.setText(String.valueOf(modelList.get(position).getOption4()));

        }
    }
}