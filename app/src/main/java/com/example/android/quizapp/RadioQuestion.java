package com.example.android.quizapp;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * RadioQuestion implements a question of RadioButton type.
 * It has only one valid answer.
 */
public class RadioQuestion extends Question {
    private RadioButton rightAnswer;
    private RadioGroup radioGroup;

    RadioQuestion(TextView labelView,
                  int falseColor,
                  int trueColor,
                  RadioGroup radioGroup,
                  RadioButton rightAnswer) {
        super(labelView, falseColor, trueColor);
        this.rightAnswer = rightAnswer;
        this.radioGroup = radioGroup;
    }

    public boolean isCorrect() {
        /* Check if the answer is correct */
        return rightAnswer.isChecked();
    }

    public void resetAnswer() {
        /* Clear all the selected values */
        radioGroup.clearCheck();
    }
}
