package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {


    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        if (numbers == null) return null;

        List<Integer> sumNumbersList = new ArrayList();
        int summary;
        int count = 0;
        int before = 0;
        for (int s : numbers) {
            if (count > 0) {
                summary = s + before;
                sumNumbersList.add(summary);
            }
            before = s;
            count++;
        }
        int minNumberPlace = sumNumbersList.indexOf(Collections.min(sumNumbersList));
        int minNumberNeighbour = minNumberPlace + 1;
        sumNumbersList.clear();
        sumNumbersList.add(minNumberPlace);
        sumNumbersList.add(minNumberNeighbour);
        return sumNumbersList;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        if (numbers == null) return null;

        int before = Integer.MAX_VALUE;
        int after = Integer.MAX_VALUE;
        int count = 0;
        Collection<Integer> sumNumbersList = new ArrayList<>();

        for (int num : numbers) {
            if (count > 1 && before > num && before > after) {
                sumNumbersList.add(before);
            }
            after = before;
            before = num;
            count++;
        }
        return sumNumbersList;

    }

    public static boolean findSequence(Collection<Integer> numbers) {
        if (numbers == null) return false;
        int size = numbers.size();
        if (size == 0) return false;

        BitSet s = new BitSet(size + 1);
        int i = 1;
        int num;

        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext(); ) {
            num = iterator.next();
            if (num < 1 || num > size) {
                return false;
            }
            s.set(num, true);
            i++;
        }

        for (i = 1; i <= size; i++) {
            if (s.get(i)) continue;
            else return false;
        }
        return true;
    }


    public static String findSimilar(Collection<String> names) {
        if (names == null) return null;
        else if (names.size() == 0) return null;

        String maxString = "";
        int maxCount = 0;
        String minString = "";
        int minCount = 0;
        Iterator listNames =  names.iterator();
        while (listNames.hasNext()) {
            String string = (String) listNames.next();
            if (string.compareTo(minString) == 0) {
                minCount++;
            } else {
                if (minCount > maxCount) {
                    maxString = minString;
                    maxCount = minCount;
                }
                minCount = 1;
                minString = string;
            }
        }
        if (minCount > maxCount) {
            maxString = minString;
            maxCount = minCount;
        }
        return maxString + ":" + maxCount;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(23);
        list.add(45);
        list.add(14);
        list.add(29);
        list.add(876);
        list.add(1);
        findMinSumPair(list);
        System.out.println(findMinSumPair(list));
        findLocalMax(list);
        System.out.println(findLocalMax(list));
    }
}
