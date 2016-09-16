package com.electromatt.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[] score = new int[5];
    int q5a;

    public void submitAnswers(View view) {
        int totalScore = 0;

        EditText et = (EditText)findViewById(R.id.q5a1);
        String etString = et.getText().toString();
        if (etString.isEmpty()) {
            q5a = 0;
        }else {
            q5a = Integer.parseInt(etString);
        }

        //Question 1
        if (checkAnswerRadio(R.id.q1a2)) {
            score[0] = 20;
            findViewById(R.id.q1).setBackgroundColor(Color.TRANSPARENT);
        } else{
            score[0] = 0;
            findViewById(R.id.q1).setBackgroundColor(Color.RED);
        }

        //Question 2
        if (checkAnswerRadio(R.id.q2a3)) {
            score[1] = 20;
            findViewById(R.id.q2).setBackgroundColor(Color.TRANSPARENT);
        } else{
            score[1] = 0;
            findViewById(R.id.q2).setBackgroundColor(Color.RED);
        }

        //Question 3
        if (checkAnswerBox(R.id.q3a1) && checkAnswerBox(R.id.q3a2) && checkAnswerBox(R.id.q3a3)){
            score[2] = 20;
            findViewById(R.id.q3).setBackgroundColor(Color.TRANSPARENT);
        }else{
            score[2] = 0;
            findViewById(R.id.q3).setBackgroundColor(Color.RED);
        }

        //Question 4
        if (checkAnswerRadio(R.id.q4a1)) {
            score[3] = 20;
            findViewById(R.id.q4).setBackgroundColor(Color.TRANSPARENT);
        }else{
            score[3] = 0;
            findViewById(R.id.q4).setBackgroundColor(Color.RED);
        }

        //Question 5
        if (q5a == 8){
            score[4] = 20;
            findViewById(R.id.q5).setBackgroundColor(Color.TRANSPARENT);
        }else{
            score[4] = 0;
            findViewById(R.id.q5).setBackgroundColor(Color.RED);
        }

        //Calculate score
        for(int x=0;x<5;x++){
            totalScore+=score[x];
        }

        //Display Score
        Toast.makeText(this, "Your score is: "+totalScore, Toast.LENGTH_LONG).show();
    }

    public boolean checkAnswerRadio(int answerId){
        return ((RadioButton) findViewById(answerId)).isChecked();
    }
    public boolean checkAnswerBox(int answerId){
        return ((CheckBox) findViewById(answerId)).isChecked();
    }

}