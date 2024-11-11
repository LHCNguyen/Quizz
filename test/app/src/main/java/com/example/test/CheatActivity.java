package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER = "lhcnguyen.quiz.answer";
    private static final String EXTRA_ANSWER_RESULT = "lhcnguyen.quiz.answer_result";
    private boolean mAnswer;
    private TextView mTextViewAnswer;
    private Button btnCheat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER, false);
        mTextViewAnswer = findViewById(R.id.ketQua);
        btnCheat = findViewById(R.id.btn_Cheat);

        btnCheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer)
                    mTextViewAnswer.setText("True");
                else
                    mTextViewAnswer.setText("False");
                setAnswerResult(true);
            }
        });
    }

    public void setAnswerResult(boolean isAnswerShow){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_RESULT, isAnswerShow);
        setResult(RESULT_OK,data);
    }

    public static boolean getAnswerShow(Intent intent){
        return intent.getBooleanExtra(EXTRA_ANSWER_RESULT, false);
    }

    public static Intent newIntent(Context pakageContext, boolean answer) {
        Intent i = new Intent(pakageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }
}