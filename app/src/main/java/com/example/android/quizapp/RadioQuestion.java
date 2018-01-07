package com.example.android.quizapp;

import android.widget.RadioButton;
import android.widget.TextView;

/**
 * RadioQuestion implements a question of RadioButton type.
 * It has only one valid answer.
 */
public class RadioQuestion extends Question {
    private RadioButton rightAnswer;

    RadioQuestion(TextView labelView,
                         int falseColor,
                         int trueColor,
                         RadioButton rightAnswer) {
        super(labelView, falseColor, trueColor);
        this.rightAnswer = rightAnswer;
    }

    public boolean isCorrect() {
        return rightAnswer.isChecked();
    }
}
