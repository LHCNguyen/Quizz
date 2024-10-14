package com.example.test;

public class Question {
    public Question(Integer question, Boolean answer) {
        Question = question;
        this.answer = answer;
    }

    private Integer Question;
    private Boolean answer = true;

    public Integer getQuestion() {
        return Question;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setQuestion(Integer question) {
        Question = question;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
