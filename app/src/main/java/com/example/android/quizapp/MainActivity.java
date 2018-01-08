package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    int score;

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

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Create the app */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initQuestions();
        resultTextView = findViewById(R.id.result);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        /* Save instance state (score and score text) */
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("score", score);
        savedInstanceState.putString("scoreText", (String) resultTextView.getText());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        /* Restore the saved state in case of restore */
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
        String oldScoreText = savedInstanceState.getString("scoreText");
        if (oldScoreText != "") {
            displayText(oldScoreText);
            calculateScore();
        }
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
        RadioGroup q1group = findViewById(R.id.q1group);
        question1 = new RadioQuestion(q1_textView, falseColor, trueColor, q1group, q1right);

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
        RadioGroup q5group = findViewById(R.id.q5group);
        question5 = new RadioQuestion(q5_textView, falseColor, trueColor, q5group, q5right);

        // Question 6
        TextView q6answer = findViewById(R.id.q6);
        question6 = new TextQuestion(q6_textView, falseColor, trueColor, q6answer, getString(R.string.question6answer));

        // Question 7
        CheckBox[] q7right = {findViewById(R.id.q7right1), findViewById((R.id.q7right2))};
        CheckBox[] q7wrong = {findViewById(R.id.q7wrong1), findViewById((R.id.q7wrong2))};
        question7 = new CheckboxQuestion(q7_textView, falseColor, trueColor, q7right, q7wrong);

        // Question 8
        RadioButton q8right = findViewById(R.id.q8right);
        RadioGroup q8group = findViewById(R.id.q8group);
        question8 = new RadioQuestion(q8_textView, falseColor, trueColor, q8group, q8right);

        // Question 9
        RadioButton q9right = findViewById(R.id.q9right);
        RadioGroup q9group = findViewById(R.id.q9group);
        question9 = new RadioQuestion(q9_textView, falseColor, trueColor, q9group, q9right);

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

    private void displayText(String textToDisplay) {
        /* Display text */
        resultTextView.setText(textToDisplay);
    }

    private void displayScore(int score) {
        /* Display the score */
        displayText(getString(R.string.result, score));
    }

    public void submit(View view) {
        /* Submit the quiz */
        score = calculateScore();
        displayScore(score);
    }

    public void resetQuiz(View view) {
        /* Reset the questions and the score */
        // Score to 0
        score = 0;
        displayScore(score);

        // Reset questions' answers
        for (Question question : questions) question.resetAnswer();

        // Reset questions' colors
        for (Question question : questions) question.setTrueColor();

        // Reset text to display
        displayText("");
    }
}
