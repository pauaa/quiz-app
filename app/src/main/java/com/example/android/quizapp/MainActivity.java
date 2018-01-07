package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RadioQuestion question1;
    TextQuestion question2;
    CheckboxQuestion question3;
    NumberQuestion question4;
    RadioQuestion question5;
    TextQuestion question6;
    CheckboxQuestion question7;
    RadioQuestion question8;
    RadioQuestion question9;
    TextQuestion question10;

    Question[] questions;

    int falseColor;
    int trueColor;

    TextView q1_textView;
    TextView q2_textView;
    TextView q3_textView;
    TextView q4_textView;
    TextView q5_textView;
    TextView q6_textView;
    TextView q7_textView;
    TextView q8_textView;
    TextView q9_textView;
    TextView q10_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initQuestions();
    }

    private void initQuestions() {
        /* Init questions with answers and all the views */

        falseColor = this.getResources().getColor(R.color.errorColor);
        trueColor = this.getResources().getColor(R.color.colorAccent);

        q1_textView = findViewById(R.id.question1);
        q2_textView = findViewById(R.id.question2);
        q3_textView = findViewById(R.id.question3);
        q4_textView = findViewById(R.id.question4);
        q5_textView = findViewById(R.id.question5);
        q6_textView = findViewById(R.id.question6);
        q7_textView = findViewById(R.id.question7);
        q8_textView = findViewById(R.id.question8);
        q9_textView = findViewById(R.id.question9);
        q10_textView = findViewById(R.id.question10);

        // Question 1
        RadioButton q1right = findViewById(R.id.q1right);
        question1 = new RadioQuestion(q1_textView, falseColor, trueColor, q1right);

        // Question 2
        TextView q2answer = findViewById(R.id.q2);
        question2 = new TextQuestion(q2_textView, falseColor, trueColor, q2answer, getString(R.string.question2answer));

        // Question 3
        CheckBox[] q3right = {findViewById(R.id.q3right1), findViewById((R.id.q3right2))};
        CheckBox[] q3wrong = {findViewById(R.id.q3wrong1), findViewById((R.id.q3wrong2))};
        question3 = new CheckboxQuestion(q3_textView, falseColor, trueColor, q3right, q3wrong);

        // Question 4
        NumberPicker q4answer = findViewById(R.id.q4);
        question4 = new NumberQuestion(q4_textView, falseColor, trueColor, q4answer, getResources().getInteger(R.integer.question4answer), 0, 7);

        // Question 5
        RadioButton q5right = findViewById(R.id.q5right);
        question5 = new RadioQuestion(q5_textView, falseColor, trueColor, q5right);

        // Question 6
        TextView q6answer = findViewById(R.id.q6);
        question6 = new TextQuestion(q6_textView, falseColor, trueColor, q6answer, getString(R.string.question6answer));

        // Question 7
        CheckBox[] q7right = {findViewById(R.id.q7right1), findViewById((R.id.q7right2))};
        CheckBox[] q7wrong = {findViewById(R.id.q7wrong1), findViewById((R.id.q7wrong2))};
        question7 = new CheckboxQuestion(q7_textView, falseColor, trueColor, q7right, q7wrong);

        // Question 8
        RadioButton q8right = findViewById(R.id.q8right);
        question8 = new RadioQuestion(q8_textView, falseColor, trueColor, q8right);

        // Question 9
        RadioButton q9right = findViewById(R.id.q9right);
        question9 = new RadioQuestion(q9_textView, falseColor, trueColor, q9right);

        // Question 10
        TextView q10answer = findViewById(R.id.q10);
        question10 = new TextQuestion(q10_textView, falseColor, trueColor, q10answer, getString(R.string.question10answer));

        questions = new Question[]{question1, question2, question3, question4, question5, question6, question7, question8, question9, question10};
    }

    private int calculateScore() {
        /* Calculate the score */
        int score = 0;

        for (Question question : questions) {
            if (question.isCorrect()) {
                score += 1;
                question.setTrueColor();
            } else {
                question.setFalseColor();
            }
        }
        return score;
    }

    private void displayScore(int score) {
        /* Display the score */
        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(getString(R.string.result, score));
    }

    public void submit(View view) {
        /* Submit the quiz */
        int score = calculateScore();
        displayScore(score);
    }
}
