package ru.progwards.java1.lessons.queues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class CollectionsSort {
    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> temp = new ArrayList<>(data);
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i) > temp.get(j)) {
                    Integer temporary;
                    temporary = temp.get(i);
                    temp.set(i, temp.get(j));
                    temp.set(j, temporary);
                }
            }
        }
    }

    public static void minSort(Collection<Integer> data) {
        //ArrayList<Integer> temp = new ArrayList<>(data);
        ArrayList<Integer> result = new ArrayList<>();

        while (data.size() > 0) {
            Integer min = Collections.min(data);
            result.add(min);
            data.remove(min);
        }
        data.addAll(result);
    }

    public static void collSort(Collection<Integer> data) {
        Collections.sort((List) data);
    }

    public static Collection<String> compareSort() {
        Collection<Integer> data = new ArrayList();
        Collection<Integer> data2 = new ArrayList();
        for (int i = 0; i < 100_00; i++) {
            data.add(random(10, 100));
            data2.add(random(10, 100));
        }
        long start1 = System.currentTimeMillis();
        mySort(data);
        long finish1 = System.currentTimeMillis();
        long result1 = finish1 - start1;
        long start2 = System.currentTimeMillis();
        collSort(data2);
        long finish2 = System.currentTimeMillis();
        long result2 = finish2 - start2;
        Collection<String> sort = new ArrayList<>();
        System.out.println(result1);
        System.out.println(result2);
        if (result1 >= result2) {
            sort.add("collSort");
            sort.add("mySort");
        } else {
            sort.add("mySort");
            sort.add("collSort");
        }
        return sort;
    }

    public static void main(String[] args) {
        CollectionsSort one = new CollectionsSort();
        //one.compareSort();
        System.out.println(one.compareSort());
    }

    //Вспомогательный метод
    private static int random(int i, int j) {
        int result = (int) (Math.random() * (j - i) + i);
        return result;
    }
}
