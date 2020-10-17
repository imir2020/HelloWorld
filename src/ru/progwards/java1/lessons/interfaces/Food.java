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
        Food one = (Food) smthHasWeigt;//в параметре передаётся объект, записываемы в интерфейсную переменную.
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
//здесь должен сортироваться enum(это гипотеза)
    public static void sort(CompareWeight[] a) {
        Food[] b = new Food[a.length];
        //Food[] b = (Food[]) new CompareWeight[a.length];//так не получится

        for (int i = 0; i < a.length; i++) {
            b[i] = (Food) a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (b[i].getWeight() > b[j].getWeight()) {
                    int temp;
                    temp = b[i].getWeight();
                    b[i] = b[j];
                    b[j].weight = temp;
                }
            }
            System.out.println(b[i]);
        }
    }
    public static void main(String[] args) {
        Food second = new Food(1500);
        second.compareWeight(new Food(1600));
        System.out.println(second.compareWeight(new Food(1500)));
        second.sort(new CompareWeight[10]);

    }
}
