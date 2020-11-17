package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static int calcEmpty(String fileName) {
        int countNull = 0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner sc = new Scanner(reader);
            try {
                while (sc.hasNextLine()) {
                    String valueIfNull = sc.nextLine();
//                    if (valueIfNull.isEmpty()) {
//                        countNull++;
//                    }
                    if (valueIfNull != null && valueIfNull.length() == 0) {
                        countNull++;
                    }
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            countNull = -1;
            return countNull;
        } catch (IOException e) {
            e.printStackTrace();
            countNull = -1;
            return countNull;
        }
        return countNull;
    }

    public static void main(String[] args) {
        LineCount lineCount = new LineCount();
        lineCount.calcEmpty("");
        System.out.println(lineCount.calcEmpty("src/ru/progwards/java1/lessons/io1/inFileName"));//
    }
}
