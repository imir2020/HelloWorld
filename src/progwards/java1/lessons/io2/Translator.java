package ru.progwards.java1.lessons.io2;

import java.util.Hashtable;

public class Translator {
    Hashtable<String, String> wordTable;

    Translator(String[] inLang, String[] outLang) {
        if (outLang.length != inLang.length) throw new ArrayIndexOutOfBoundsException("Длина массивов одинакова!!!");
        int count = inLang.length;
        wordTable = new Hashtable<>(count);
        for (int i = 0; i < count; i++) {
            wordTable.put(inLang[i].toLowerCase(), outLang[i].toLowerCase());
        }
    }
    public String translateWord(String word) {
        String result = wordTable.get(word.toLowerCase());
        if (result == null) return word;
        if (Character.isUpperCase(word.charAt(0))) {
            return Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
        }
        return result;
    }

    public String translate(String sentence) {
        StringBuilder result = new StringBuilder(128);
        int wordBeginIndex = -1;
        int len = sentence.length();

        for(int i = 0; i < len; i++) {
            char c = sentence.charAt(i);
            if (Character.isLetter(c)) {
                if (wordBeginIndex < 0){
                    wordBeginIndex = i;
                }
            } else {
                if (wordBeginIndex >= 0) {
                    result.append(translateWord(sentence.substring(wordBeginIndex, i)));
                    wordBeginIndex = -1;
                }
                result.append(c);
            }
        }
        if (wordBeginIndex >= 0) {
            result.append(translateWord(sentence.substring(wordBeginIndex)));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Translator t = new Translator(new String[]{"puck"}, new String[]{"****"});
        t.translate("What the puck are you shooting?");
        System.out.println(t.translate("What the puck are you shooting?"));
    }
}
