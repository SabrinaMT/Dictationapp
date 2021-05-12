package com.example.taicanlanguage;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView question;
    TextView answer01;
    TextView answer02;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        question = itemView.findViewById(R.id.question);
        answer01 = itemView.findViewById(R.id.answer01_text);
        answer02 = itemView.findViewById(R.id.answer02_text);
    }
}
