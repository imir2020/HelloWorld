package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    private int ind = 0;
    private int[] first = new int[0];
    //private int[] second;


    public DIntArray() {
    }

    public void add(int num) {
        first = Arrays.copyOf(first, first.length + 1);
        first[first.length -1] = num;
        ind++;
        //test
        for (int i = 0; i < first.length; i++) {
            System.out.print(first[i]);
        }
        System.out.println();
    }

    public void atInsert(int pos, int num) {
        int[] temp  = Arrays.copyOf(first, first.length + 1 );
        for (int i = 0; i < first.length; i++) {
            temp[i] = first[i];
        }
        for (int i = temp.length - 1 ; i >= pos; i--) {
            if(i > pos){
                temp[i] = temp[i -1];
            }
            if(i == pos) {
                temp[pos] = num;
            }
        }
        first = Arrays.copyOf(temp, temp.length );
        //test
        for (int i = 0; i < temp.length; i++) {
            System.out.print(first[i] + " ");
        }
    }

    public void atDelete(int pos) {
        int[] temp  = Arrays.copyOf(first, first.length - 1 );
        for (int i = 0; i < temp.length; i++) {
            if (i < pos) {
                temp[i] = first[i];
            }
            if(i >= pos){
                temp[i] = first[i +1];
            }
        }
        first = Arrays.copyOf(temp, temp.length );
        //test
        for (int i = 0; i < temp.length; i++) {
            System.out.print(first[i] + " ");
        }
    }
    public int at(int pos){
        return first[pos];
    }
    public static void main(String[] args) {
        DIntArray one = new DIntArray();
        one.add(-3);
        one.add(5);
        one.add(-7);
        one.add(9);
        System.out.println();
        //System.out.println(one.ind);
        one.atInsert(3, 6745);
        System.out.println();
         one.atDelete(2);
        System.out.println();
        one.at(3);
        System.out.println(one.at(2));
    }
}
