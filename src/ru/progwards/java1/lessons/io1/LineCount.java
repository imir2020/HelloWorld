package ru.progwards.java1.lessons.io1;

import org.w3c.dom.ls.LSOutput;

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
                    System.out.println(valueIfNull);
//                    if (valueIfNull.trim().isEmpty()) {
//                        countNull++;
//                    }
                    if(valueIfNull.length() ==0){
                        countNull++;
                    }
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(countNull);
        return countNull;
    }

    public static void main(String[] args) {
        LineCount lineCount = new LineCount();
        lineCount.calcEmpty("src/ru/progwards/java1/lessons/io1/inFileName");
    }
}
