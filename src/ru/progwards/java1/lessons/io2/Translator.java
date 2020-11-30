package ru.progwards.java1.lessons.io2;

public class Translator {
    private String[] inLang;
    private String[] outLang;
    Translator(String[] inLang, String[] outLang){
        this.inLang = inLang;
        this.outLang = outLang;
    }
    public String translate(String sentence){

        return null;
    }
    public static void main(String[] args) {
        Translator two = new Translator(new String[]{"hello", "world"},
                new String[]{"привет", "мир"});
        two.translate("Hello World!");
    }
}
