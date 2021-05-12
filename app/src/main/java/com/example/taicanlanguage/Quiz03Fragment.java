package com.example.taicanlanguage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Quiz03Fragment extends AppCompatActivity {


        private TextView mQuestion;
        private EditText mEditAnswer;
        private TextView mScoreView;
        private Button mButton;

        private int mQuestionNumber = 0;
        private TextView mTotalNum;
        private String mAnswer;
        public int mScore = 0;
        private TextView mCustomAnswer;
        private TextView mCorrectAnswer;

        private Firebase mQuestionRef, mAnswerRef;

        public static final String EXTRA_NUMBER = "com.example.taicanlanguage.EXTRA_NUMBER";
        int result;



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_quiz03);

            getSupportActionBar().setTitle("Exercise");


            mQuestion = (TextView) findViewById(R.id.question);
            mButton = (Button) findViewById(R.id.summit_button);
            mEditAnswer = (EditText) findViewById(R.id.answer);
            mScoreView = (TextView) findViewById(R.id.score);
            mCustomAnswer = (TextView) findViewById(R.id.customAnswer);
            mCorrectAnswer = (TextView) findViewById(R.id.correctAnswer);
            mTotalNum = (TextView) findViewById(R.id.totalNum);

            Firebase.setAndroidContext(this);

            updateQuestion();
            updateScore(mScore);






            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (TextUtils.isEmpty(mEditAnswer.getText().toString())){
                        Toast.makeText(Quiz03Fragment.this, "Please enter your answer", Toast.LENGTH_SHORT).show();
                    }
                    else if(mEditAnswer.getText().toString().equals(mAnswer)){
                        mScore = mScore + 1;
                        result = mScore;
                        updateScore(mScore);
                        updateQuestion();
                        String CustomAnswer = mEditAnswer.getText().toString();
                        mCustomAnswer.setText("Your Answer: " + CustomAnswer);
                        mCorrectAnswer.setText("Correct Answer: " + mAnswer);
                        Toast.makeText(Quiz03Fragment.this,"Correct", Toast.LENGTH_SHORT).show();
                        mEditAnswer.getText().clear();
                    }
                    else{
                        updateQuestion();
                        String CustomAnswer = mEditAnswer.getText().toString();
                        mCustomAnswer.setText("Your Answer: " + CustomAnswer);
                        mCorrectAnswer.setText("Correct Answer: " + mAnswer);
                        Toast.makeText(Quiz03Fragment.this,"Wrong", Toast.LENGTH_SHORT).show();
                        mEditAnswer.getText().clear();
                    }

                }
            });
        }


        private void updateScore(int Score){
            mScoreView.setText("Score: "+ mScore);
        }

        private void updateQuestion(){
            if (mQuestionNumber<=24){
                mQuestionRef = new Firebase("https://quiz-139ca-default-rtdb.firebaseio.com/Sheet3/"+ mQuestionNumber +"/question");
                mQuestionRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String question = dataSnapshot.getValue(String.class);
                        mQuestion.setText(question);


                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }
                });

                mAnswerRef = new Firebase("https://quiz-139ca-default-rtdb.firebaseio.com/Sheet3/"+ mQuestionNumber +"/answer");
                mAnswerRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        mAnswer = dataSnapshot.getValue(String.class);

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

                mQuestionNumber++;
                mTotalNum.setText("Questions " + mQuestionNumber + "/25");
                mButton.setText("Summit");

            }else{

                mButton.setText("Next");
                mEditAnswer.setEnabled(false);
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Quiz03Fragment.this, ScoreFragment.class);
                        intent.putExtra(EXTRA_NUMBER, result);
                        startActivity(intent);

                    }
                });
            }
        }


    }
