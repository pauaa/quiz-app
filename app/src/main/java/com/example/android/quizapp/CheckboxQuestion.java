package com.example.android.quizapp;

import android.widget.CheckBox;
import android.widget.TextView;

/**
 * CheckboxQuestion implements a question of Checkbox type.
 * It can have multiple right answers.
 */
public class CheckboxQuestion extends Question {
    private CheckBox[] rightAnswers;
    private CheckBox[] wrongAnswers;

    CheckboxQuestion(TextView labelView,
                            int falseColor,
                            int trueColor,
                            CheckBox[] rightAnswers,
                            CheckBox[] wrongAnswers) {
        super(labelView, falseColor, trueColor);
        this.rightAnswers = rightAnswers;
        this.wrongAnswers = wrongAnswers;

    }

    public boolean isCorrect() {
        /* Check if the checked and unchecked values are correctly checked */
        boolean rightChecked = true;
        boolean wrongNotChecked = true;
        for (int i = 0; i < rightAnswers.length && rightChecked; i++)
            if (!rightAnswers[i].isChecked()) {
                rightChecked = false;
            }

        for (int i = 0; i < wrongAnswers.length && wrongNotChecked; i++)
            if (wrongAnswers[i].isChecked()) {
                wrongNotChecked = false;
            }
        return rightChecked && wrongNotChecked;
    }

    public void resetAnswer() {
        /* Clear all checkboxes */
        for (CheckBox checkbox : rightAnswers) checkbox.setChecked(false);
        for (CheckBox checkbox : wrongAnswers) checkbox.setChecked(false);
    }
}
