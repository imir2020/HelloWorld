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
        Food[] b = new Food[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = (Food)a[i];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (b[i].getWeight() > b[j].getWeight()) {
                    int temp;
                    temp = b[i].getWeight();
                    b[i] = b[j];
                    b[j].weight = temp;
                }
            }
            System.out.println(b[i]);//test
            System.out.println(b[i].getWeight());//test
        }
    }
    public static void main(String[] args) {
        Food second = new Food(1500);
        second.compareWeight(new Food(1600));
        System.out.println(second.compareWeight(new Food(1500)));
        CompareWeight[] a = new CompareWeight[]{new Food(43), new Food(49), new Food(56) };
        second.sort(a);

    }
}
