package ru.progwards.java2.lessons.generics;


public class ArraySort {

    public ArraySort() {
    }

    public static <T extends Comparable> T[] sort(T[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                int res = list[i].compareTo(list[j]);
                if (res > 0) {
                    T temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[]{234, 538, -23, 57843, -334, 4857};
        String[] ton = new String[]{"dhf", "djhf", "Adhhdf", "Rdf"};
        sort(list);
        Integer[] lis = sort(list);
        for (Integer s: lis) {
            System.out.println(s);
        }

        String[] t = sort(ton);
        for (String r: t ) {
            System.out.println(r);
        }
    }
}
