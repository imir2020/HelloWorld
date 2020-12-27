package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        set1.addAll(set2);
        return set1;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        set1.retainAll(set2);
        return set1;

    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
       // if (set1 == null) return new HashSet<Integer>();
        //Set<Integer> result = new HashSet<Integer>(set1);
        //if (set2 != null) result.removeAll(set2);
        set1.removeAll(set2);
        return set1;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        /*
        В методе лучше заводить временную коллекцию, в которую передать входящую коллекцию,
        чтобы не изменять содержимое входящей коллекции.
         */
        Set<Integer> result1 = set1 != null ? new HashSet<Integer>(set1) : new HashSet<Integer>();
        Set<Integer> result2 = set2 != null ? new HashSet<Integer>(set2) : new HashSet<Integer>();
        result1.removeAll(set2);
        result2.removeAll(set1);
        result1.addAll(result2);
        return result1;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set1.add(i * 2);
        }
        set1.add(1123);
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 11; i++) {
            set2.add(i * 2);
            set2.add(i * 3);
        }
        set2.add(3000);
        //System.out.println(union(set1, set2));
        //System.out.println(intersection(set1, set2));
        System.out.println(difference(set1, set2));
        //System.out.println(symDifference(set1, set2));
    }
}
