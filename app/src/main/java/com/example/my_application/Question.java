package com.example.my_application;

public class Question {
    private int questionResId;
    private boolean answerTrue;
   // private boolean answerFalse;

    public Question(int questionResId, boolean answerTrue) {
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;
        //this.answerFalse = answerFalse;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

//    public boolean isAnswerFalse() {
//        return answerFalse;
//    }
//
//    public void setAnswerFalse(boolean answerFalse) {
//        this.answerFalse = answerFalse;
//    }
}
