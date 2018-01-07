package com.example.android.quizapp;

import android.widget.TextView;


/**
 * TextQuestion implements a question with text type
 */
public class TextQuestion extends Question {
    private String rightAnswer;
    private TextView input;

    TextQuestion(TextView labelView,
                         int falseColor,
                         int trueColor,
                         TextView input,
                         String rightAnswer) {
        super(labelView, falseColor, trueColor);
        this.rightAnswer = rightAnswer;
        this.input = input;
    }

    public boolean isCorrect() {
        String answer = input.getText().toString();
        return answer.equals(rightAnswer);
    }
}
