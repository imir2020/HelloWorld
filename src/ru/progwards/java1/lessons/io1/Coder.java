package ru.progwards.java1.lessons.io1;

import java.io.*;

public class Coder {
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        FileInputStream fIn = null;
        BufferedInputStream bIn = null;
        FileOutputStream fOut = null;
        BufferedOutputStream bOut = null;
        try {
            fIn = new FileInputStream(inFileName);
            bIn = new BufferedInputStream(fIn);
            fOut = new FileOutputStream(outFileName);
            bOut = new BufferedOutputStream(fOut);
            int i;
            while ((i = bIn.read()) != -1) {
                bOut.write(code[i]);
            }
        } catch (Throwable e) {
            FileWriter fEOut = null;
            BufferedWriter bEOut = null;
            try {
                fEOut = new FileWriter(logName, true);
                bEOut = new BufferedWriter(fEOut);
                bEOut.write(e.getMessage());
            } catch (Throwable e2) {
            } finally {
                try {
                    if (bEOut != null) bEOut.close();
                    if (fEOut != null) fEOut.close();
                } catch (Throwable e3) {
                }
            }
        } finally {
            try {
                if (bOut != null) bOut.close();
                if (fOut != null) fOut.close();
                if (bIn != null) bIn.close();
                if (fIn != null) fIn.close();
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        char[] code = new char[256];
        for (int i = 0; i < 256; i++) code[i] = (char) (Character.isDigit((char) i) ? i + 1 : i);
        codeFile("src/ru/progwards/java1/lessons/io1/inFileName",
                "src/ru/progwards/java1/lessons/io1/outFileName", code,
                "src/ru/progwards/java1/lessons/io1/logName");
    }
}