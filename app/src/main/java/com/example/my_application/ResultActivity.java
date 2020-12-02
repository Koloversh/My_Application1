package com.example.my_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ArrayList<String> result = new ArrayList<>();
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResult = findViewById(R.id.textViewResult);
        result = getIntent().getStringArrayListExtra("result");
        String string = "";
        int i = 1;

        for(String str : result){
            string = string + "\n" + i + " - " + str;
            i++;
        }

        textViewResult.setText(string);
    }
}