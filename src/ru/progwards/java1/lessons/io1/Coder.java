package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileReader readInFile = new FileReader(inFileName);
            FileWriter writeInFile = new FileWriter(outFileName);
            try {
                int symbol;
                while ((symbol = readInFile.read()) != -1) {
                    System.out.println(symbol + " inPut");
                    System.out.println((char) symbol + " output");//test
                    writeInFile.write((char) symbol);
                }
            } finally {
                readInFile.close();
                writeInFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Coder coder = new Coder();
        char[] code = {3, 8};
        String logName = " Something";
        coder.codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                "src/ru/progwards/java1/lessons/io1/outFileName", code, logName);
    }
}
