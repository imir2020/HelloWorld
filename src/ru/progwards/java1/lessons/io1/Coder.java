package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        FileReader readInFile = null;
        try {
            readInFile = new FileReader(inFileName);
            FileWriter writeInFile = new FileWriter(outFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int symbol;
            ArrayList<Character> list = new ArrayList<>();
            //char massSymbol;
            while ((symbol = readInFile.read()) != -1) {
                list.add((char) symbol);
            }
            // что-то похожее на шифрование.
            for (int i = 0; i < list.size(); i++) {
                list.add(i, (char) (list.get(i) + code[i]));
            }
            //Block for test
            for (char s : list) {//
                System.out.println(s);
            }


        } catch (IOException ex) {
            ex.printStackTrace();

        }


        //System.out.println(symbol + " inPut");//test
        // System.out.println((char) symbol + " output");//test
        //writeInFile.write((char) symbol);
        //Попробовать считать данные из файла с помощью readOfBytes()  в байтовый  массив
        // затем зашифровать  байты в цикле(посмотреть в сети, как это можно делать),
        //  записать в конечный файл
        // и обработать исключение на длину массива - OutOfBoundException

    }

    public static void main(String[] args) {
        Coder coder = new Coder();
        char[] code = {3, 8};
        String logName = "Something";
        coder.codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                "src/ru/progwards/java1/lessons/io1/outFileName", code, logName);
    }
}
