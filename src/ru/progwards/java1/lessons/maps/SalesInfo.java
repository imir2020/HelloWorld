package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesInfo {

    private static Map<String, Double> goods;
    private static Map<String, AbstractMap.SimpleEntry<Double, Integer>> consumers;

    // загрузить заказы из CSV файла: String, String, int, double
    public static int loadOrders(String fileName) {
        goods = new TreeMap();
        consumers = new TreeMap();
        int result = 0;
        try (FileReader r = new FileReader(fileName); Scanner s = new Scanner(r)) {
            while (s.hasNext()) {
                result += processLine(s.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName + ":\n" + e.getMessage());
        }
        return result;
    }

    // загрузить содержимое строки, вернем количество успешно загруженных заказов
    private static int processLine(String str) {
        String[] words = str.split(",");
        if (words.length == 4) {
            try {
                String fio = words[0].trim();
                String good = words[1].trim();
                int cnt = Integer.parseInt(words[2].trim());
                double sum = Double.parseDouble(words[3].trim());
                goods.put(good, goods.containsKey(good) ? goods.get(good) + sum : sum);
                if (consumers.containsKey(fio)) {
                    AbstractMap.SimpleEntry<Double, Integer> simpleEntry = consumers.get(fio);
                    sum += simpleEntry.getKey();
                    cnt += simpleEntry.getValue();
                }
                consumers.put(fio, new AbstractMap.SimpleEntry(sum, cnt));
                return 1;
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public static Map<String, Double> getGoods() {
        return goods;
    }

    public static Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        return consumers;
    }

    public static void main(String[] args) {
        loadOrders("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\SalesInfo.java");
        System.out.println(getGoods());
        System.out.println(getCustomers());
    }
}