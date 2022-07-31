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

public class subtraction extends AppCompatActivity {
    TextView number1, number2, number3, optn1, optn2, optn3, optn4,qustion;
    model model;
    List<model> modelList;
    Random random;
    int postion;
    int question = 1;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);
        addition();
        AdmobHelper.loadAdaptiveBannerAd(this);
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
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(subtraction.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
        modelList.add(model = new model(14, 21, 7, 5, 7, 9, 10));
        modelList.add(model = new model(67, 47, 20, 16, 20, 13, 12));
        modelList.add(model = new model(70, 53, 17, 17, 12, 18, 14));
        modelList.add(model = new model(69, 24, 45, 45, 66, 40, 42));
        modelList.add(model = new model(89, 80, 9, 8, 9, 10, 11));
        modelList.add(model = new model(21, 15, 6, 4, 7, 9, 6));
        modelList.add(model = new model(74, 35, 39, 40, 35, 45, 39));
        modelList.add(model = new model(45, 34, 11, 22, 14, 11, 10));
        modelList.add(model = new model(52, 43, 9, 7, 9, 8, 5));
        modelList.add(model = new model(27, 25, 2, 4, 5, 2, 1));
        modelList.add(model = new model(61, 21, 40, 38, 46, 40, 49));
        modelList.add(model = new model(50, 42, 8, 8, 9, 10, 12));
        modelList.add(model = new model(43, 22, 21, 19, 21, 15, 13));
        modelList.add(model = new model(43, 30, 13, 20, 17, 13, 14));
        modelList.add(model = new model(34, 21, 13, 14, 10, 11, 13));
    }

    void settext(int position) {
        if (question == 11) {
            Intent resultactivity = new Intent(subtraction.this, result.class);
            finish();
            AdmobHelper.showAdmobInterstitial(subtraction.this);
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