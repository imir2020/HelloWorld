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
   
    public static void sort(CompareWeight[] a) {
       Food[] mas = (Food[]) new CompareWeight[10];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < mas.length; j++) {
                if (mas[i].getWeight() > mas[j].getWeight()) {
                    int temp;
                    temp = mas[i].getWeight();
                    mas[i] = mas[j];
                    mas[j].weight = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Food second = new Food(1500);
        second.compareWeight(new Food(1600));
        System.out.println(second.compareWeight(new Food(1500)));
    }
}
