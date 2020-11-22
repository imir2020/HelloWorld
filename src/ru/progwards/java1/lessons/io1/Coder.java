package ru.progwards.java1.lessons.io1;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
Проверить класс с помощью робота, посмотреть на выдаваемые ошибки, что возможно - устранить, остальное
выяснить на консультации.

Читать файлы можно и ПОСТРОЧНО, но перекодировать - только посимвольно.
 */

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) throws IOException {
        FileReader readInFile = new FileReader(inFileName);
        FileWriter writeInFile = new FileWriter(outFileName);
        try {
            int symbol;
            ArrayList<Character> buffer = new ArrayList<>();

            while ((symbol = readInFile.read()) != -1) {
                buffer.add((char) symbol);
            }

            char key = code[0];

            // что-то похожее на шифрование.
            for (int i = 0; i < buffer.size(); i++) {
                buffer.set(i, (char) (buffer.get(i) + key));
                writeInFile.write(buffer.get(i));
            }

            //Block for test
            for (char s : buffer) {
                System.out.println(s);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            // какие конкретно ошибки должно "отлавливать" это исключение?
            writeInFile = new FileWriter("logName");
            writeInFile.write(ex.getMessage() + " Mistake");
        } finally {
            readInFile.close();
            writeInFile.close();
        }

    }

    public static void main(String[] args) {

        char[] code = {3};
        try {
            codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                    "src/ru/progwards/java1/lessons/io1/outFileName", code,
                    "src/ru/progwards/java1/lessons/io1/logName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
