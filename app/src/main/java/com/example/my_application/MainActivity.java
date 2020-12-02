package com.example.my_application;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;

    private Question[] questions = new Question[] {
            new Question(R.string.question1,true), //0
            new Question(R.string.question2,false), //1
            new Question(R.string.question3,false), //2
            new Question(R.string.question4,true), //3
            new Question(R.string.question5,true) //4
    };

    private ArrayList<String> result = new ArrayList<>();

    private int questionIndex = 0; // номер вопроса

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        textView = findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);

        textView.setText(questions[questionIndex].getQuestionResId());

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    result.add(getString(R.string.correct));
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
//                    questionIndex = (questionIndex + 1) % questions.length;// вопросы идут по кругу, ощибка не возникает
//                    textView.setText(questions[questionIndex].getQuestionResId());
                    result.add(getString(R.string.incorrect));
                }

                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("result", result);
                    startActivity(intent);
                } else if (questionIndex < questions.length - 1) {
                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }
            }
        });

        //кнопка "Нет". В конструкции if-else поменял местами "неправльно\правильно" для логичного ответа при нажатии на кнопку

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    result.add(getString(R.string.incorrect));
                }
                else{
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
//                    questionIndex = (questionIndex + 1) % questions.length;// вопросы идут по кругу, ощибка не возникает
//                    textView.setText(questions[questionIndex].getQuestionResId());
                    result.add(getString(R.string.correct));
                }

                if (questionIndex == questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("result", result);
                } else if (questionIndex < questions.length - 1) {
                    questionIndex++;
                    textView.setText(questions[questionIndex].getQuestionResId());
                }
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("System INFO", "onStart() запущен" );
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("System INFO", "onResume() запущен" );
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("System INFO", "onPause() запущен" );
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("System INFO", "onStop() запущен" );
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt("questionIndex", questionIndex);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("System INFO", "onDestroy() запущен" );
    }
}