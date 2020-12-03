package ru.progwards.java1.lessons.io2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {
    public static String repeatStr(String value, int count) {
        StringBuilder s = new StringBuilder(count);
        for (int i = count; i > 0; i--) s.append(value);
        return s.toString();
    }

    static class CensorException extends RuntimeException {

        String errName;
        String fileName;

        CensorException(String errName, String fileName) {
            this.errName = errName;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return errName + ":" + fileName;
        }
    }
    public static void censorFile(String inoutFileName, String[] obscene) {

        if (inoutFileName == null || inoutFileName.compareTo("") == 0) throw new CensorException("Имя файла" +
                " передавать обязательно", inoutFileName);
        if (obscene == null) throw new CensorException("Последовательность слов" +
                " нужно передавать", inoutFileName);

        int obLen;
        String[] stars;
        try {
            obLen = obscene.length;
            stars = new String[obLen];
            for (int i = 0; i < obLen; i++) {
                stars[i] = repeatStr("*", obscene[i].length());
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }

        String tmpFileName = inoutFileName + ".tmp";
        String lineSeparator = System.getProperty("line.separator");
        boolean firstLine = true;

        try (FileReader r = new FileReader(inoutFileName); Scanner s = new Scanner(r);
             FileWriter w = new FileWriter(tmpFileName)) {
            while (s.hasNext()) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    w.write(lineSeparator);
                }
                String str = s.nextLine();
                for (int i = obLen - 1; i >= 0; i--) {
                    str = str.replace(obscene[i], stars[i]);
                }
                w.write(str);
            }
        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        try {
            File f = new File(inoutFileName);
            f.delete();
            File n = new File(tmpFileName);
            n.renameTo(f);
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) {
        String[] obsceneWords = {"Java", "Oracle", "Sun", "Microsystems"};
        censorFile("src/ru/progwards/java1/lessons/io2/inoutFileName", obsceneWords);
    }
}
