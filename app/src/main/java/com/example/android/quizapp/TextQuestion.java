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
        /* Check if the answer is correct */
        String answer = input.getText().toString();
        return answer.equals(rightAnswer);
    }

    public void resetAnswer() {
        /* Clear the text answer */
        input.setText("");
    }
}
