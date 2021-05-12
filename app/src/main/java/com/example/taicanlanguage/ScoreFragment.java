package com.example.taicanlanguage;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ScoreFragment extends AppCompatActivity {

    private Button backButton;
    private TextView textview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_score);

        backButton = (Button) findViewById(R.id.backButton);
        textview = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        int result = intent.getIntExtra(QuizFragment.EXTRA_NUMBER, 0);
        textview.setText("Total Score: " + result);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreFragment.this, MainActivity.class));
            }
        });

        }



}