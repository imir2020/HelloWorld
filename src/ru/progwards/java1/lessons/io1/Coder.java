package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Переделать с  использованием try - with- resourses
Читать про данную конструкцию, её возможности и ограничения.
 */
public class Coder {

    public static  void codeFile(String inFileName, String outFileName, char[] code, String logName) throws IOException {

        FileWriter writeLogName;
        try ( FileReader readInFile = new FileReader(inFileName);
              FileWriter writeInFile = new FileWriter(outFileName, false)){
            int symbol;
                while ((symbol = readInFile.read()) != -1) {
                    // System.out.println(symbol);//test
                    writeInFile.write(code[symbol]); //hint&tips
                }
        } catch (IOException e){
            writeLogName = new FileWriter("logName");
            writeLogName.write(e.getMessage());
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
