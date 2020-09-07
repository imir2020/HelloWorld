package ru.progwards.java1.lessons.arrays;

public class DIntArray {
    private int index = 5;
    private int[] someInt = new int[index];//{3, 5, 7, 9, 11};
    private int[] newSomeInt;

    public DIntArray() {
    }

    public void add(int num) {
        newSomeInt = new int[index + 1];
        for (int i = 0; i < newSomeInt.length; i++) {
            if (i < someInt.length) {
                newSomeInt[i] = someInt[i];
            } else {
                newSomeInt[i] = num;
            }
        }
    }

    public void atInsert(int pos, int num) {
        newSomeInt = new int[index + 1];
        if (pos < newSomeInt.length) {
            for (int i = 0, j = 0; i < newSomeInt.length && j < someInt.length; i++, j++) {
                if (i < pos) {
                    newSomeInt[i] = someInt[j];
                }
                if (i == pos) {
                    newSomeInt[i] = num;
                }
                if (i > pos) {
                    newSomeInt[i] = someInt[j];
                }
            }
        } else {
            System.out.println("FirstMistake!!!");
        }
    }

    public void atDelete(int pos) {
        newSomeInt = new int[index - 1];
        if (pos < newSomeInt.length) {
            for (int i = 0, j = 0; i < newSomeInt.length && j < someInt.length; i++, j++) {
                if (j < pos) {
                    newSomeInt[i] = someInt[j];
                }
                if (j >= pos) {
                    newSomeInt[i] = someInt[j + 1];
                }
            }
        } else {
            System.out.println("SecondMistake!!!");
        }
    }

    public int at(int pos) {
        return newSomeInt[pos];
    }

    public static void main(String[] args) {
        DIntArray one = new DIntArray();
        //one.add(12);
        //one.atInsert(4, 6745);
        one.atDelete(3);
        //one.at(3);
        //System.out.println(one.at(3));
    }
}
