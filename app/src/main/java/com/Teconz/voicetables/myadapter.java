package com.Teconz.voicetables;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.viewholder> {
    private final ArrayList<Integer> userlist;
    Context context;
    String firstnum;
    TextToSpeech ttx;
    int result;
    ArrayList<String> datatext = new ArrayList<>();

    public myadapter(ArrayList<Integer> userlist, Context context, String firstnum, TextToSpeech ttx,
                     int result) {
        this.userlist = userlist;
        this.context = context;
        this.firstnum = firstnum;
        this.ttx = ttx;
        this.result = result;
    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(context).inflate(R.layout.activity_item,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        String number1=firstnum;
        String number2=String.valueOf(userlist.get(position));

    int n1= Integer.parseInt(number1);
    int n2= Integer.parseInt(number2);
    int res=n1*n2;
    holder.alltext.setText(n1+"  X  "+n2+"  =  "+res);

    datatext.add(n1+" Multiply "+n2+" = "+res);

    holder.alltext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Toast.makeText(context,"Voice feature not supported in your Device",Toast.LENGTH_LONG).show();
            }else {
                ttx.speak(datatext.get(position), TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    });

    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        public  static  TextView number1,alltext;
        LinearLayout line0;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            alltext=itemView.findViewById(R.id.alltext);
            line0=itemView.findViewById(R.id.line0);
        }
    }
}