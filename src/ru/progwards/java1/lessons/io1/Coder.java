package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Переделать с  использованием try - with- resourses
Читать про данную конструкцию, её возможности и ограничения.
 */
public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try ( FileReader readInFile = new FileReader(inFileName);
              FileWriter writeInFile = new FileWriter(outFileName)) {
            int symbol;
            while ((symbol = readInFile.read()) != -1) {
                // System.out.println(symbol);//test
                writeInFile.write(code[symbol]); //hint&tips
            }

        } catch (IOException e) {

            try {
                //System.out.println(e.getMessage());
                FileWriter writeLogName = new FileWriter(logName);
               // String temp = e.getMessage();
                writeLogName.write(e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[8213];
        codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                "src/ru/progwards/java1/lessons/io1/outFileName", code,
                "src/ru/progwards/java1/lessons/io1/logName");
    }
}
