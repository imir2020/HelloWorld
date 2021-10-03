package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    private static String deleteFilterChars(String string, String filter) {
        StringBuilder builder = new StringBuilder();
        int lOfString = string.length();
        for (int i = 0; i < lOfString; i++) {
            if (filter.indexOf(string.charAt(i)) < 0) {
                builder.append(string.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader reader = new FileReader(inFileName);
        Scanner sc = new Scanner(reader);
        FileWriter writer = new FileWriter(outFileName);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            str = deleteFilterChars(str, filter);
            writer.write(str);
        }
        reader.close();
        writer.close();
        sc.close();
    }

    public static void main(String[] args) {
        try {
            filterFile("src/ru/progwards/java1/lessons/io1/inFileName",
                    "src/ru/progwards/java1/lessons/io1/outFileName",
                    " -,.()");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
