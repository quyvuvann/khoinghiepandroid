package com.example.ailatrieuphu;

public class Answer {
    String content;
    Boolean isCorect;

    public Answer(String content, Boolean isCorect) {
        this.content = content;
        this.isCorect = isCorect;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCorect() {
        return isCorect;
    }

    public void setCorect(Boolean corect) {
        isCorect = corect;
    }
}
