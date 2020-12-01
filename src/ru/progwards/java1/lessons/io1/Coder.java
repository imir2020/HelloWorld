package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) throws IOException {
        FileReader readInFile = new FileReader(inFileName);
        FileWriter writeInFile = new FileWriter(outFileName, false);
        try {
            int symbol;
            try {
                while ((symbol = readInFile.read()) != -1) {
                   // System.out.println(symbol);//test
                    writeInFile.write(code[symbol]); //hint&tips
                }
            } finally {
                writeInFile.close();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (IOException ex) {
            writeInFile = new FileWriter("logName");
            writeInFile.write(ex.getMessage());
        } finally {
            try {
                readInFile.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
            try {
                writeInFile.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[8213];
        try {
            codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                    "src/ru/progwards/java1/lessons/io1/outFileName", code,
                    "src/ru/progwards/java1/lessons/io1/logName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
