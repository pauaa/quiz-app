package com.example.android.quizapp;

import android.widget.TextView;

/**
 * Question implements a question that has a label and colours that indicate
 * if the answer is right or wrong. Most of the question functions are in the
 * sub-classes.
 */
public class Question {
    private TextView labelView;
    private int falseColor;
    private int trueColor;

    public Question(TextView labelView,
                    int falseColor,
                    int trueColor) {
        this.labelView = labelView;
        this.falseColor = falseColor;
        this.trueColor = trueColor;
    }

    public boolean isCorrect() {
        /* Check if the question has right answer. Implementation in sub-class. */
        return false;
    }

    void setColor(int color) {
        /* Change the label colour */
        labelView.setTextColor(color);
    }

    void setFalseColor() {
        /* Set the text colour to indicate answer is wrong */
        setColor(falseColor);
    }

    void setTrueColor() {
        /* Set the text colour to indicate answer is right */
        setColor(trueColor);
    }

    void resetAnswer() {}

}

