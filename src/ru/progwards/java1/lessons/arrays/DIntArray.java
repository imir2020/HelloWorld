package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int index = 0;
    private int[] someInt = new int[0];
    private int[] newSomeInt;

    public DIntArray() {
    }

    public void add(int num) {
        someInt = Arrays.copyOf(someInt, someInt.length + 1);
        someInt[index] = num;
        index++;
    }

    public void atInsert(int pos, int num) {
        newSomeInt = new int[someInt.length + 1];
        for (int i = 0; i < someInt.length; i++) {
            if (i < pos) {
                newSomeInt[i] = someInt[i];
            } else {
                newSomeInt[i + 1] = someInt[i];
            }
        }
        newSomeInt[pos] = num;
    }

    public void atDelete(int pos) {
        int[] newSomeInt = new int[someInt.length - 1];
        for (int i = 0; i < someInt.length; i++) {
            if(i < pos){
                newSomeInt[i] = someInt[i];
            }
            if (someInt[i] == someInt[pos]) {
                break;
            }
        }
        for (int j = pos; j < newSomeInt.length; j++) {
            newSomeInt[j] = someInt[j + 1];
        }
    }

    public int at(int pos) {
        return someInt[pos];
    }

    public static void main(String[] args) {
        DIntArray one = new DIntArray();
        one.add(3);
        one.add(5);
        one.add(7);
        one.add(9);
        one.atInsert(3, 6745);
        System.out.println();
        one.atDelete(2);
        System.out.println();
        //one.at(3);
        System.out.println(one.at(0));
    }
}
