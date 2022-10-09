package com.example.ailatrieuphu;

import java.util.List;

public class Question {
    int number;
    String content;
    List<Answer> answerList;

    public Question(int number, String content, List<Answer> answerList) {
        this.number = number;
        this.content = content;
        this.answerList = answerList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
