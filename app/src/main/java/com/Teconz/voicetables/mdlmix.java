package com.Teconz.voicetables;

public class mdlmix {
    int number1, number2, result, option1, option2, option3, option4;
    String addi;


    public mdlmix(int number1, int number2, String addi, int result, int option1, int option2, int option3, int option4) {
        this.number1 = number1;
        this.number2 = number2;
        this.addi=addi;
        this.result = result;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getOption1() {
        return option1;
    }

    public void setOption1(int option1) {
        this.option1 = option1;
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }

    public int getOption3() {
        return option3;
    }

    public void setOption3(int option3) {
        this.option3 = option3;
    }

    public int getOption4() {
        return option4;
    }

    public void setOption4(int option4) {
        this.option4 = option4;
    }

    public String getAddi() {
        return addi;
    }

    public void setAddi(String addi) {
        this.addi = addi;
    }
}