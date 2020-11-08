package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

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
        if (this.getWeight() < one.getWeight()) {
            return CompareResult.LESS;
        }else if (this.getWeight() == one.getWeight()) {
           return CompareResult.EQUAL;
        }else  {
            return CompareResult.GREATER;
        }
    }

    @Override
    public String toString() {
        return "I am Food " + getWeight();
    }
    //Задача 3. Сортировка интерфейса на основе ArraySort:
//Ошибка 1: incompatible types: ru.progwards.java1.lessons.interfaces.Animal[] cannot be converted to int[]


    public static void main(String[] args) {
//        Food second = new Food(1500);
//        // second.compareWeight(new Food(1600));
//        //System.out.println(second.compareWeight(new Food(1500)));
//       CompareWeight[] a = new CompareWeight[]{new Animal(654), new Animal(43), new Animal(89),
////                new Animal(75)};
//        System.out.println(Arrays.asList(a));

    }
}
