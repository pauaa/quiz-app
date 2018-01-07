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
        input.setMinValue(minValue);
        input.setMaxValue(maxValue);
    }

    public boolean isCorrect() {
        int answer = input.getValue();
        return answer == rightAnswer;
    }
}
