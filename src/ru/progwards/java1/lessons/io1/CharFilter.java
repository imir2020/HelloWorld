package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) {
        try {
            FileReader reader = new FileReader(inFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CharFilter charFilter = new CharFilter();
        // charFilter.
    }
}
