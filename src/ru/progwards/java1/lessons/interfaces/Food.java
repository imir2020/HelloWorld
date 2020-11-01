package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food one = (Food) smthHasWeigt;
        CompareResult result = null;
        if (getWeight() < one.getWeight()) {
            result = CompareResult.LESS;
        }
        if (getWeight() == one.getWeight()) {
            result = CompareResult.EQUAL;
        }
        if (getWeight() > one.getWeight()) {
            result = CompareResult.GREATER;
        }
        return result;
    }

    public static void sort(CompareWeight[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            a[i].compareWeight(a[i + 1]);
            if (a[i].compareWeight(a[i + 1]) != CompareResult.LESS) {
                CompareWeight temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
            //System.out.println(a[i].compareWeight(a[i + 1]));
        }
    }

    public static void main(String[] args) {
        Food second = new Food(1500);
        // second.compareWeight(new Food(1600));
        //System.out.println(second.compareWeight(new Food(1500)));
        CompareWeight[] a = new CompareWeight[]{new Animal(654), new Animal(43), new Animal(89),
                new Animal(75)};
        second.sort(a);

    }
}
