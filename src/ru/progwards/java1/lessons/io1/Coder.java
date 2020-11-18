package ru.progwards.java1.lessons.io1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            FileInputStream readInFile = new FileInputStream(inFileName);
            FileOutputStream writeInFile = new FileOutputStream(outFileName);
            try {
                while(readInFile.available() >=0){
                }
            } finally {
                readInFile.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
            
        }



    }

    public static void main(String[] args) {
        Coder coder = new Coder();
        //coder.
    }
}
