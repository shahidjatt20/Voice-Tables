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

public class multiplication extends AppCompatActivity {
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
        setContentView(R.layout.activity_multiplication);
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
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                    random = new Random();
                    postion = random.nextInt(modelList.size());
                    question++;
                    correct++;
                    settext(postion);
                } else {
                    Toast.makeText(multiplication.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
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
        modelList.add(model = new model(4, 2, 8, 7, 8, 10, 9));
        modelList.add(model = new model(6, 2, 18, 20, 18, 17, 10));
        modelList.add(model = new model(6, 6, 36, 37, 30, 36, 23));
        modelList.add(model = new model(6, 4, 24, 21, 25, 27, 24));
        modelList.add(model = new model(3, 3, 9, 8, 9, 10, 6));
        modelList.add(model = new model(3, 7, 21, 24, 21, 34, 36));
        modelList.add(model = new model(7, 5, 35, 39, 24, 35, 49));
        modelList.add(model = new model(2, 8, 16, 15, 26, 16, 21));
        modelList.add(model = new model(8, 4, 32, 42, 31, 32, 36));
        modelList.add(model = new model(2, 5, 10, 15, 21, 12, 10));
        modelList.add(model = new model(6, 7, 42, 54, 34, 42, 60));
        modelList.add(model = new model(3, 4, 12, 10, 29, 12, 19));
        modelList.add(model = new model(9, 6, 54, 61, 54, 56, 63));
        modelList.add(model = new model(2, 3, 6, 9, 5, 6, 7));
        modelList.add(model = new model(4, 4, 16, 17, 16, 15, 21));
    }

    void settext(int position) {
        if (question == 11) {
            Intent resultactivity = new Intent(multiplication.this, result.class);
            finish();
            AdmobHelper.showAdmobInterstitial(multiplication.this);
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