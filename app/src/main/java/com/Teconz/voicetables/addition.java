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

public class addition extends AppCompatActivity {
    TextView number1, number2, number3, optn1, optn2, optn3, optn4, qustion;
    model model;
    List<model> modelList;
    Random random;
    int postion;
    int question = 1;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
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
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(addition.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
        qustion = findViewById(R.id.qustion);
    }

    void add_data() {
        modelList.add(model = new model(14, 21, 35, 51, 43, 35, 49));
        modelList.add(model = new model(65, 66, 131, 68, 131, 170, 71));
        modelList.add(model = new model(68, 69, 137, 137, 72, 173, 74));
        modelList.add(model = new model(69, 24, 93, 93, 66, 89, 42));
        modelList.add(model = new model(19, 80, 99, 44, 99, 100, 109));
        modelList.add(model = new model(15, 21, 36, 44, 41, 34, 36));
        modelList.add(model = new model(74, 35, 109, 100, 99, 45, 109));
        modelList.add(model = new model(21, 34, 55, 45, 66, 37, 55));
        modelList.add(model = new model(22, 43, 65, 76, 69, 87, 65));
        modelList.add(model = new model(27, 25, 52, 45, 65, 52, 70));
        modelList.add(model = new model(61, 21, 82, 98, 89, 82, 79));
        modelList.add(model = new model(50, 42, 92, 100, 109, 92, 102));
        modelList.add(model = new model(43, 22, 65, 69, 70, 65, 63));
        modelList.add(model = new model(23, 34, 57, 59, 57, 64, 70));
        modelList.add(model = new model(34, 21, 55, 57, 54, 55, 72));
    }

    void settext(int position) {
        if (question == 11) {
            Intent resultactivity = new Intent(addition.this, result.class);
            finish();
            AdmobHelper.showAdmobInterstitial(this);
            resultactivity.putExtra("res", correct);
            startActivity(resultactivity);
        } else {
            qustion.setText("Q :"+question+"/10");
            number1.setText(String.valueOf(modelList.get(position).getNumber1()));
            number2.setText(String.valueOf(modelList.get(position).getNumber2()));
            optn1.setText(String.valueOf(modelList.get(position).getOption1()));
            optn2.setText(String.valueOf(modelList.get(position).getOption2()));
            optn3.setText(String.valueOf(modelList.get(position).getOption3()));
            optn4.setText(String.valueOf(modelList.get(position).getOption4()));
        }
    }
}