package com.example.taicanlanguage;

public class vocab {

    public String question, answer01, answer02;

    public vocab(){

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer01() {
        return answer01;
    }

    public void setAnswer01(String answer01) {
        this.answer01 = answer01;
    }

    public String getAnswer02() {
        return answer02;
    }

    public void setAnswer02(String answer02) {
        this.answer02 = answer02;
    }

    public vocab(String question, String answer01, String answer02) {
        this.question = question;
        this.answer01 = answer01;
        this.answer02 = answer02;
    }
}
