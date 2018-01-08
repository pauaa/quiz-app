package com.example.android.quizapp;

import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * NumberQuestion implements a question of NumberPicker type.
 * It has a range of numbers as options and one valid answer.
 */
public class NumberQuestion extends Question {
    private int rightAnswer;
    private NumberPicker input;
    private int minValue;

    NumberQuestion(TextView labelView,
                          int falseColor,
                          int trueColor,
                          NumberPicker input,
                          int rightAnswer,
                          int minValue,
                          int maxValue) {
        super(labelView, falseColor, trueColor);
        this.rightAnswer = rightAnswer;
        this.input = input;
        this.minValue = minValue;
        input.setMinValue(minValue);
        input.setMaxValue(maxValue);
    }

    public boolean isCorrect() {
        /* Check if the selected number is correct */
        int answer = input.getValue();
        return answer == rightAnswer;
    }

    public void resetAnswer() {
        /* Reset the answer by setting the minimum value in */
        input.setValue(minValue);
    }
}
