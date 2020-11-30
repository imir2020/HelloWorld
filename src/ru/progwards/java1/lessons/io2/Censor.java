package ru.progwards.java1.lessons.io2;

public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public class CensorException{

    }
    public static void main(String[] args) {
        String[] obsceneWords = {"Java", "Oracle", "Sun", "Microsystems"};
        censorFile("src/ru/progwards/java1/lessons/io2/This2", obsceneWords);
    }
}
