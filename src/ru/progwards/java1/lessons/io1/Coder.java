
package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try (FileReader readInFile = new FileReader(inFileName);
             FileWriter writeInFile = new FileWriter(outFileName)) {
            int symbol;
            while ((symbol = readInFile.read()) != -1) {
                writeInFile.write(code[symbol]); //hint&tips
            }
        } catch (IOException e) {
            try {
                FileWriter writeLogName = new FileWriter(logName);
                writeLogName.write(e.getMessage());
                writeLogName.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[8213];
        for (int symbol = 0; symbol < 8213; symbol++) code[symbol] = (char) (Character.isDigit((char) symbol)
                ? symbol + 1 : symbol);
        codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                "src/ru/progwards/java1/lessons/io1/outFileName", code,
                "src/ru/progwards/java1/lessons/io1/logName");
    }
}
