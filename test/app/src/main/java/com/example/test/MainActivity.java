package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButtonTrue;
    private Button mButtonFalse;
    private Button mButtonNext;
    private TextView Question;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true),
            new Question(R.string.question5, true),
            new Question(R.string.question6, true),
            new Question(R.string.question7, true),
            new Question(R.string.question8, false)
    };

    private int currentQuestionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTrue = findViewById(R.id.button_true);
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        mButtonFalse = findViewById(R.id.button_false);
        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        Question = findViewById(R.id.question);
        mButtonNext = findViewById(R.id.button_next);
        updateQuestion();
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestionIndex++;
                if (currentQuestionIndex < mQuestionBank.length) {
                    updateQuestion();
                } else {
                    Question.setText("Đã hết câu hỏi");
                    mButtonNext.setEnabled(false);
                }
            }
        });
    }

    private void updateQuestion() {
        Question.setText(mQuestionBank[currentQuestionIndex].getQuestion());
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = mQuestionBank[currentQuestionIndex].getAnswer();
        if (userAnswer == correctAnswer) {
            Toast.makeText(MainActivity.this, R.string.thongbao_true,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.thongbaos_false, Toast.LENGTH_SHORT).show();
        }
    }
}



